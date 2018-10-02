package com.rky.restfulwebservice.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public String helloWorldInternationalized(@RequestHeader(value="Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("morning.message", null, locale);
	}
	
	
	

}
