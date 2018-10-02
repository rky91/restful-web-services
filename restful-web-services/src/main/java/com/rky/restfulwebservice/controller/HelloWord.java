package com.rky.restfulwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/helloworld")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-int")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("morning.message", null, LocaleContextHolder.getLocale());
	}
	
	
	

}
