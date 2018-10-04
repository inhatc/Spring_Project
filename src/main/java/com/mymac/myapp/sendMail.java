package com.mymac.myapp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {
	public void sendEmail(String email, String auth) throws AddressException, MessagingException{
		String host = "smtp.gmail.com";
		String subject = "Anywhere 인증번호";
		String fromName = "Anywhere";
		String from = "dlfgksdl@naver.com";
		String to1 = email;
		final String user = "bbb8323";
		
		String content = "인증번호 ["+auth+"]";
		
			Properties props = new Properties();
			
			//props.put("mail.smtp.starttls.enable", "true");
			//props.put("mail.transport.protocol", "smtp");
			//props.put("mail.stmp.host", host);
			//props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			//props.put("mail.smtp.port", "465");
			//props.put("mail.smtp.user", from);
			//props.put("mail.smtp.auth", "true");
			
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user,"940940qq");
				}
			});
			mailSession.setDebug(true);
			
		MimeMessage message  = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(user));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
		message.setSubject(subject);
		message.setText(content);
		
		Transport.send(message);
		System.out.println("message send complate");
	}

}
