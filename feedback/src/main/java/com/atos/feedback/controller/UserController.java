package com.atos.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.UserService;
import com.atos.feedback.vo.RoleVO;
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

	@PostMapping("update")
	public UserVO update(@RequestBody UserVO user) {
		return userService.saveUser(user);
	}

	@GetMapping("approve/{userId}")
	public String approve(@PathVariable final Long userId) {
		userService.approve(userId);
		return "OK";
	}

	@DeleteMapping("delete/{userId}")
	public String delete(@PathVariable final Long userId) {
		return userService.delete(userId);
	}

//	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("all")
	public List<UserVO> findAll() {
		return userService.findAll();
	}

	@GetMapping("roles")
	public List<RoleVO> findRoles() {
		return userService.findRoles();
	}
}
