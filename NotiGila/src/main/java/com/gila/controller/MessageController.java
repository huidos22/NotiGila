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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gila.jpa.model.dto.MessageDTO;
import com.gila.validator.MessageValidator;

@Controller
public class MessageController {

	@Autowired
	private MessageValidator messageFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(messageFormValidator);
	}

	@PostMapping(path = "/message")
	public String sendMessage(@ModelAttribute("clienteForm") @Validated MessageDTO messageDTO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		return "index";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("recipient", "World");
		model.addAttribute("now", LocalDateTime.now());
		return "index";
	}

	@GetMapping("/properties")
	@ResponseBody
	java.util.Properties properties() {
		return System.getProperties();
	}
}
