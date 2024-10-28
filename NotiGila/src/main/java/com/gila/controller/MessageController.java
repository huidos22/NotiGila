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

import com.gila.jpa.model.dto.MessageDTO;
import com.gila.validator.MessageValidator;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MessageController {

	@Autowired
	private MessageValidator messageFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(messageFormValidator);
	}

	@PostMapping(path = "/message")
	public ModelAndView sendMessage(@ModelAttribute("messageForm") @Validated MessageDTO messageDTO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		String view = "index";
	    return new ModelAndView(view, "messageForm", new MessageDTO());
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
