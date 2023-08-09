package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		try {
	         Socket socket = new Socket("localhost", 7777);
	         System.out.println("서버에 연결되었습니다");

	         File file = new File("d:/d_other/펭귄.jpg");
	         
	         if(!file.exists()) {
	            System.out.println("복사할 원본 파일 " + file.getName() + " 이(가) 없습니다.");
	            System.out.println("복사 작업을 중지합니다...");
	            return;
	         }
	         
	         FileInputStream fin = new FileInputStream(file);
	         BufferedInputStream bin = new BufferedInputStream(fin);
	         
	         OutputStream out = socket.getOutputStream();
	         
	         int data;
	         while ( (data = fin.read()) != -1 ) {
	            out.wait(data);
	         }
	         
	         socket.close();
	         
	   } catch (Exception e) {
	      // TODO: handle exception
	   }
	}
}
