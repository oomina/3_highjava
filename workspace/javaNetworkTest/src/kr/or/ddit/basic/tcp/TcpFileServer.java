package kr.or.ddit.basic.tcp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) throws IOException {
		try {
	         ServerSocket server = new ServerSocket(7777);
	         System.out.println("서버가 준비 중입니다");
	         
	         Socket socket = server.accept();
	         System.out.println("서버에 연결되었습니다");
	         
	         InputStream in = socket.getInputStream();
	         
	         File file = new File("d:/d_other/연습용");
	         
	         if(!file.exists()) {
	            file.mkdir();
	         }
	         
	         FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/펭귄.jpg");
	         BufferedOutputStream bout = new BufferedOutputStream(fout);
	         
	         int data;
	         while ( (data = in.read()) != -1 ) {
	            bout.wait(data);
	         }
	         
	         fout.close();
	         in.close();
	         
	         socket.close();
	         
	   } catch (Exception e) {
	      // TODO: handle exception
	   }
	}
}
