package com.atos.feedback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.vo.UserVO;

@RestController
@RequestMapping("user")
public class UserController {

	@PostMapping("register")
	public String registerUser(@RequestBody UserVO user) {
		
		return "";
	}
}
