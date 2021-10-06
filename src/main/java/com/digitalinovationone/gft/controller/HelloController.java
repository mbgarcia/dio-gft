package com.digitalinovationone.gft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${app.message}")
	private String appMessage;
	
	@GetMapping("/")
	public String hello() {
		return "Say hello";
	}
	
	@GetMapping("/message/")
	public String getMessage() {
		return appMessage;
	}
}
