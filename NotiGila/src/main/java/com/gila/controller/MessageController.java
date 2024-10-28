package com.gila.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gila.business.CannotSendMessageException;
import com.gila.jpa.model.dto.MessageDTO;
import com.gila.service.MessageService;
import com.gila.validator.MessageValidator;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MessageController {

	@Autowired
	private MessageValidator messageFormValidator;
	@Autowired
	private MessageService messageService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(messageFormValidator);
	}

	@PostMapping(path = "/message")
	public ModelAndView sendMessage(@ModelAttribute("messageForm") @Validated MessageDTO messageDTO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		try {
			messageService.sendMessage(messageDTO);
		} catch (CannotSendMessageException e) {
			log.error(e.getMessage());
		}

		String view = "index";
		return new ModelAndView(view, "messageForm", messageDTO);
	}

	@GetMapping("/")
	public ModelAndView index(Model model, HttpServletRequest request) {
		model.addAttribute("now", LocalDateTime.now());
		String view = "index";
		return new ModelAndView(view, "messageForm", new MessageDTO());
	}

	@GetMapping("/properties")
	@ResponseBody
	java.util.Properties properties() {
		return System.getProperties();
	}

}
