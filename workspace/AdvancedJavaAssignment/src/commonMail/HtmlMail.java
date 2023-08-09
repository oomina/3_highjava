package commonMail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class HtmlMail {

	public static void main(String[] args) throws EmailException {
		
		String from = "";
		String password = "";
		String to ="";
		
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);
		email.setAuthentication(from, password);
		
		email.setCharset("UTF-8");
		email.setFrom(from);
		email.addTo(to);
		email.setSubject("HTML 테스트 메일입니다");
		email.setHtmlMsg("<html>아파치 로고 - <img src=\"http://www.apache.org/images/asf_logo_wide.gif\"></html>");
		
		email.send();
		
		if(email.getSentDate() != null) {
			System.out.println("메일 보내기 성공!^_^");
		} else {
			System.out.println("메일 보내기 실패ㅠ_ㅠ");
		}
		
		
	}
}
