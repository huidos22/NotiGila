package com.gila.service;

import org.apache.tomcat.util.modeler.NotificationInfo;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("mailService")
@Service
public class EmailService extends NotificationInfo {
	private static final long serialVersionUID = 1L;
	private MailSender mailSender;

	/**
	 * Sends a simple mail
	 * 
	 * @param from
	 * @param to
	 * @param subject
	 * @param msg
	 */
	public void sendMail(String from, String to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

	
}
