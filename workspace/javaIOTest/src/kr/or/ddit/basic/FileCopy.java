package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
	문제) 'd:/d_other'폴더에 있는 '펭귄.jpg'파일을 
		 'd:/d_other/연습용'폴더에 '복사본_펭귄.jpg'파일로 복사하는 프로그램을 작성하시오.
*/

public class FileCopy {

	public static void main(String[] args) {
		/*
		 * File f1 = new File("d:/d_other/펭귄.jpg"); File f2 = new
		 * File("d:/d_other/연습용/복사본_펭귄.jpg");
		 * 
		 * try { FileWriter fw = new FileWriter("d:/d_other/연습용/복사본_펭귄.jpg");
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		try {
			fin = new FileInputStream("d:/d_other/펭귄.jpg");
			fout = new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			
			int c;
			while ((c=fin.read()) != -1) {
				fout.write(c);
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if(fin!=null) try { fin.close(); } catch (IOException e) {}
			if(fout!=null) try { fout.close(); } catch (IOException e) {}
		}
	}
}
