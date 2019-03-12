package com.atos.feedback.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	/*
	 * @GetMapping(value = "authenticate", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public String authenticate() { return
	 * "My Rating"; }
	 */
	@GetMapping("authenticate")
	public Principal user(Principal user, HttpSession session) {
		System.out.println("pind" + user.getName());
		session.setAttribute("username", user.getName());
		System.out.println("session in login Value:>"+session.getId());
		return user;
	}
}
