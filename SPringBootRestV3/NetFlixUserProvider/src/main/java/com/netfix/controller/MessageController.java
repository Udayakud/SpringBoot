package com.netfix.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	
	
	private MessageSource messageSource;
	
	
	public MessageController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}



	@GetMapping("/good-wish-internationalisation")
	public String getGoodLuckMessage() {
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.wishes.message", null,"Defaultmessage",locale);
	}

}
