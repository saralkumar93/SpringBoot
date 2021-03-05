package com.smart.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



@Service
public class EmailService {
	
	public boolean sendEmail(String subject, String message,String to) {
		
		//rest of the code
		
		boolean f=false;
		
		String from="saralkumar93@gmail.com";
		
		// variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" +properties);
		
		// setting important information to properties object
		
		// host set
		
    	properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
	  //  properties.put("mail.smtp.starttls.enable", "true");
//		
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.socketFactory.port", "465");
//		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.port", "465");
		//step 1: to get the session object
		
		Session session = Session.getInstance(properties, new Authenticator(){
		
			@Override 
		    protected PasswordAuthentication getPasswordAuthentication() {
			
			return new PasswordAuthentication("saralkumar93@gmail.com","iloveyoubaba@143");
			
		}
	});
		session.setDebug(true);
		
		//step 2: compose the message [text,multi media]
		MimeMessage m= new MimeMessage(session);
		
		try {
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send
			
			
			//step 3: send the message using Transport class
			
			Transport.send(m);
			
			System.out.println("send sucess.......");
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
		}
		
		
		
		
		
	}


