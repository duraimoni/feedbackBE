package com.atos.feedback.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("logind")
public class LoginController {
	
	@GetMapping(value = "authenticate", produces=MediaType.APPLICATION_JSON_VALUE)
	public String authenticate() {
		return "My Rating";
	}
}
