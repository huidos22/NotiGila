package com.gila.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gila.jpa.model.dto.MessageDTO;

@Component("messageValidator")
public class MessageValidator implements Validator{

	@Override
	public void validate(Object target, Errors errors) {
		MessageDTO mes = (MessageDTO)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "NotEmpty.messageForm.message");
		if(mes.getMessage() != null || mes.getMessage().length() <= 0){
			errors.rejectValue("message", "NotEmpty.messageForm.message");
		}
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return MessageDTO.class.equals(clazz);
	}
}
