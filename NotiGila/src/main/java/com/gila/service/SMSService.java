package com.gila.service;

import org.apache.tomcat.util.modeler.NotificationInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gila.business.CannotSendMessageException;
import com.gila.business.Notification;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@AllArgsConstructor
@Log4j2
@Component("smsService")
@Service
public class SMSService extends NotificationInfo implements Notification {

	private static final long serialVersionUID = 1L;

	@Override
	public void send(String message) throws CannotSendMessageException{
		// TODO Auto-generated method stub
		log.info("Send Message via SMS");
	}

}
