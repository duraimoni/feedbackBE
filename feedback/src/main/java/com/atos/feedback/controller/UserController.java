package com.atos.feedback.controller;

import java.util.List;

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
	public UserVO registerUser(@RequestBody UserVO user) {

		return userService.saveUser(user);
	}

	@GetMapping("{userId}")
	public UserVO findUser(@PathVariable final Long userId) {
		return userService.findUser(userId);
	}

	@GetMapping("update/{userId}")
	public UserVO update(@RequestBody UserVO user) {
		return userService.saveUser(user);
	}

	@GetMapping("delete/{userId}")
	public UserVO delete(@PathVariable final Long userId) {
		return userService.findUser(userId);
	}

	@GetMapping("all")
	public List<UserVO> findAll() {
		return userService.findAll();
	}
}
