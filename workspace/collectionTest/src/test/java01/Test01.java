package test.java01;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		{
			Properties properties = System.getProperties();
			Set<Object> keySet = properties.keySet();
			for (Object o : keySet) {
				Object object = properties.get(o);
				System.out.println(o + " : " + object); // file.encoding=utf-8
			}
		}
		System.exit(0);
		
		
		String data1 = "한글";
		String data2 = "12abc";
		
		/** 한글 바이트 수 */
		
		{
			// UTF-8
			byte[] bytes = data1.getBytes("utf-8");
			System.out.println("utf-8 바이트수 : " + bytes.length);
			String string = new String(bytes);
			System.out.println("바이트 문자열변환 : " + string);
		}
		
		
		// EUC-KR
		{
			// EUC-KR
			byte[] bytes = data1.getBytes("EUC-KR");
			System.out.println("EUC-KR 바이트수 : " + bytes.length);
			String string = new String(bytes);
			System.out.println("바이트 문자열변환1 : " + string);
			String string2 = new String(bytes,"euc-kr");
			System.out.println("바이트 문자열변환2 : " + string2);
		}
		
		
	}
}
