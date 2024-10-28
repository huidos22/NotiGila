package com.gila.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gila.business.CannotSendMessageException;
import com.gila.jpa.model.Category;
import com.gila.jpa.model.Channel;
import com.gila.jpa.model.Message;
import com.gila.jpa.model.User;
import com.gila.jpa.model.dto.MessageDTO;
import com.gila.repository.MessageRepository;
import com.gila.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Component("messageService")
@Service
@Log4j2
public class MessageService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	private PushService pushService;
	@Autowired
	private SMSService smsService;
	@Autowired
	private MessageRepository messageRepository;

	public void sendMessage(MessageDTO message) throws CannotSendMessageException {

		var category = message.getCategory();

		List<User> usersCat = userRepository.findByCategory(category);
		for (Iterator<User> iterator = usersCat.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();

			List<Channel> channels = user.getChannels();
			for (Iterator<Channel> iterator2 = channels.iterator(); iterator2.hasNext();) {
				Channel channel = (Channel) iterator2.next();

				switch (channel.getChannelName()) {
				case "SMS":

					smsService.send(message.getMessage());

					break;
				case "EMAIL":
					emailService.sendMail("system@gila.com", user.getEmail(), "Email notification",
							message.getMessage());
					break;
				case "PUSH":
					pushService.send(message.getMessage());
					break;
				default:
					break;
				}
				new Message();
				Message newMessage = Message.builder().body(message.getMessage()).category(new Category())
						.creationDate(new Date()).build();
				messageRepository.saveAndFlush(newMessage);
			}

		}

	}
}
