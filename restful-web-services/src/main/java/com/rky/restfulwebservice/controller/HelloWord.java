package com.rky.restfulwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
	
	@GetMapping("/helloworld")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	
	

}
