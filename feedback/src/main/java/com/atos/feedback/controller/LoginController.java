package com.atos.feedback.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

/*	@GetMapping(value = "authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public String authenticate() {
		return "My Rating";
	}
*/
	@GetMapping("authenticate")
	public Principal user(Principal user) {
		System.out.println("pind" + user.getName());
		return user;
	}
}
