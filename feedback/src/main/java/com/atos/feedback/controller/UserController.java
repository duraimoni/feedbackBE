package com.atos.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.UserService;
import com.atos.feedback.vo.UserVO;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("register")
	public String registerUser(@RequestBody UserVO user) {
		userService.saveUser(user);
		return "";
	}
	
	@GetMapping("{userId}")
	public UserVO findUser(@PathVariable final Long userId) {
		userService.findUser(userId);
		return null;
	}
}
