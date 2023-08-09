package commonMail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonMail {

    public static void main(String[] args) throws EmailException {

 	   String from = "";
 	   String password = "";
 	   String to = "";
      
       Email email = new SimpleEmail();
       email.setCharset("UTF-8");
       email.setHostName("smtp.naver.com");
       email.setSmtpPort(587);
       email.setStartTLSEnabled(true);
       email.setAuthentication(from, password);

       email.setFrom(from);
       email.addTo(to);
       email.setSubject("제목제목");
       email.setMsg("내용");

       email.send();
       System.out.println("메일 보내기 성공!^_^");
    }
}