package commonMail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailAttach {

	public static void main(String[] args) throws EmailException {
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("D:/D_Other/펭귄.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Penguin.jpg");
		attachment.setName("Penguin1.jpg");
		String from = "";
		String password = "";
		String to = "";
		
		MultiPartEmail email = new MultiPartEmail();
		email.setCharset("UTF-8");
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);
		email.setAuthentication(from, password);
		email.setFrom(from);
		email.addTo(to);
		email.setSubject("첨부파일 테스트 메일");
		email.setMsg("내용내용");
		
		email.attach(attachment);
		email.send();
		
		if(email.getSentDate() != null) {
			System.out.println("메일 보내기 성공!^_^");
		} else {
			System.out.println("메일 보내기 실패ㅠ_ㅠ");
		}
		
		
	}
}
