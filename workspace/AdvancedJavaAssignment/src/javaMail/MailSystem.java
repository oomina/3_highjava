package javaMail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSystem {
   public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
	   String from = "";
	   String password = "";
	   String to = "";
     
       String host = "smtp.naver.com";

       Properties properties = System.getProperties();
       properties.setProperty("mail.smtp.host", host);
       properties.setProperty("mail.smtp.port", "587");
       properties.setProperty("mail.smtp.starttls.enable", "true");
       properties.setProperty("mail.smtp.auth", "true");
      
       Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(from, password);
          }
      });

       try {
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(from));
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          message.setSubject("제목javaMail");
          message.setText("내용javaMail");

          Transport.send(message);
          System.out.println("메일 보내기 성공!^_^");

       } catch (MessagingException mex) {
    	   System.out.println("메일 보내기 실패ㅠ_ㅠ");
       }
  }
}

