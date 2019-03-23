package com.cognizant.outreach.vfs.service;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.config.AppConfig;
import com.cognizant.outreach.vfs.util.EmailTemplate;

@Service
public class EmailService {

	@Autowired
	private AppConfig appConfig;

	private Session session;
	private Properties props;

	@PostConstruct
	public void setUpEmailService() {
		props = new Properties();
		props.put("mail.smtp.auth", appConfig.getValueOfKey("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", appConfig.getValueOfKey("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", appConfig.getValueOfKey("mail.smtp.host"));
		props.put("mail.smtp.port", appConfig.getValueOfKey("mail.smtp.port"));
		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(appConfig.getValueOfKey("mail.smtp.username"),
						appConfig.getValueOfKey("mail.smtp.password"));
			}
		});
	}

	public boolean sendFeedbackMail(String toAddress, String username, String emailContent) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(appConfig.getValueOfKey("mail.smtp.from")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
			message.setSubject("Outreach Communications");

			MimeMultipart multipart = new MimeMultipart("related");

			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = EmailTemplate.REGSITERED_AND_PARTICIPATED.replace("#UserName", username)
					.replace("#emailContent", emailContent);

			messageBodyPart.setContent(htmlText, "text/html");

			multipart.addBodyPart(messageBodyPart);
//			multipart.addBodyPart(getMessageBodyPart("Cognizant_Outreach_Logo.png", "Cognizant_Outreach_Logo"));
//			multipart.addBodyPart(getMessageBodyPart("divider.png", "divider"));
//			multipart.addBodyPart(getMessageBodyPart("rounder-dwn.png", "rounder-dwn"));
//			multipart.addBodyPart(getMessageBodyPart("rounder-up.png", "rounder-up"));

			message.setContent(multipart);
			Transport.send(message);

			System.out.println("Sent message successfully....");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public BodyPart getMessageBodyPart(String sourceName, String contentId) throws Exception {
		DataSource datasource = new FileDataSource(Thread.currentThread().getContextClassLoader().getResource(sourceName).getFile());
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(datasource));
		messageBodyPart.setHeader("Content-ID", "<" + contentId + ">");
		messageBodyPart.setDisposition(MimeBodyPart.INLINE);
		return messageBodyPart;
	}
	
	public boolean sendEmaiAlert(String distributionList, String emaiContent, File attachment) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(appConfig.getValueOfKey("mail.smtp.from")));
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(distributionList));
			message.setSubject("Outreach Admin Communications");

			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setContent(emaiContent, "text/html");
			DataSource datasource = new FileDataSource(attachment);
			messageBodyPart.setDataHandler(new DataHandler(datasource));
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);
			Transport.send(message);

			System.out.println("Sent batch message successfully....");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

}
