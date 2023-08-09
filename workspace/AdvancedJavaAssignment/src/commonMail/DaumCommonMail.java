package commonMail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class DaumCommonMail {

	public static void main(String[] args) throws EmailException {
		
		String from = "";
		String password = "";
		String to = "";
		
		Email email = new SimpleEmail();
		email.setCharset("UTF-8");
		email.setHostName("smtp.daum.net");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthentication(from, password);
		
		email.setFrom(from);
		email.addTo(to);
		email.setSubject("제목");
		email.setContent("테스트 메일의 내용입니다.", "text/plain; charset=UTF-8");
		
		email.send();
		
		if(email.getSentDate() != null) {
			System.out.println("메일 보내기 성공!^_^");
		} else {
			System.out.println("메일 보내기 실패ㅠ_ㅠ");
		}
	}
}
