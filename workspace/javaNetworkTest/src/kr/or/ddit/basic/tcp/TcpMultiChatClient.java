package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
   
   
   public void clientStart(){
      try {
         
         String serverIp = "localhost";
         
         Socket socket = new Socket(serverIp, 7777);
         System.out.println("서버에 연결되었습니다.");
         System.out.println();
         
         // 메시지를 전송하는 스레드 생성
         ClientSender sender = new ClientSender(socket);
         
         // 메시지를 수신하는 스레드 생성
         ClientReceiver receiver = new ClientReceiver(socket);
         
         sender.start();
         receiver.start();
         
      } catch (Exception e) {
         // TODO: handle exception
      }
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new TcpMultiChatClient().clientStart();
   }
   
   // 메시지 전송용 스레드
   class ClientSender extends Thread{
      private Socket socket;
      private DataInputStream dis;
      private DataOutputStream dos;
      
      private String name;
      private Scanner scan;
      
      // 생성자
      public ClientSender(Socket socket) { 
         this.socket = socket;
         scan = new Scanner(System.in);
         
         try {
            // 수신용 송신용 객체 생성
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            
            if(dos!=null){
               // 클라이언트가 처음 실행되면 자신의 대화명(이름)을 입력받아 서버로 전송하고 
               // 대화명의 중복 여부를 feedBack으로 받아서 확인한다.
               
               System.out.println("대화명: ");
               String name = scan.nextLine();
               
               while(true){ // 대화명이 중복될때의 경우를위해 반복문으로 묶음
               dos.writeUTF(name); // 이름을 서버로 전송@@
               
               String feedBack = dis.readUTF(); // feedBack결과를 read로 받아서 확인한다.##
               
               if("이름중복".equals(feedBack)){ // 대화명이 중복되면
                  System.out.println(name+"은 이름이 중복됩니다.");
                  System.out.println("다른 이름을 입력하세요.");
                  System.out.println("대화명: ");
                   name = scan.nextLine();
                  
               }else{ // 중복되지 않을때
                  this.name = name;
                  System.out.println(name+"이름으로 대화방에 입장했습니다.");
                  break;
                  
               }
               
               }
            }
         } catch (Exception e) {
            // TODO: handle exception
         }
      }
   
         @Override
         public void run() {
         try {
            while(dos!=null){
               // 키보드로 입력한 메시지를 서버로 전송한다.
               dos.writeUTF("["+name+"]: "+scan.nextLine());
            }
         } catch (Exception e) {
            // TODO: handle exception
         }
         }
   }
   //메시지 수신용 스레드
   class ClientReceiver extends Thread{
      private Socket socket;
      private DataInputStream dis;
      
      // 생성자
      public ClientReceiver(Socket socket) {
         this.socket = socket;
         try {
            dis = new DataInputStream(socket.getInputStream());
         } catch (Exception e) {
            // TODO: handle exception
         }
      }
      
      @Override
      public void run() {
         try {
            while(dis!=null){
               // 서버가 보내온 메시지를 받아서 화면에 출력한다.
               System.out.println(dis.readUTF());
            }
         } catch (Exception e) {
            // TODO: handle exception
         }
      }
      
   }
}