package com.atos.feedback.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.DomainService;
import com.atos.feedback.service.UserService;
import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.RoleVO;
import com.atos.feedback.vo.UserVO;

@RestController
@RequestMapping("user")
public class UserController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService userService;
	@Autowired
	DomainService domainService;

	@PostMapping("register")
	public UserVO registerUser(@RequestBody UserVO user) {
		LOGGER.info(" registerUser service");
		return userService.saveUser(user);
	}

	@GetMapping("{userId}")
	public UserVO findUser(@PathVariable final Long userId) {
		LOGGER.info(" findUser service");
		return userService.findUser(userId);
	}

	@PostMapping("update")
	public UserVO update(@RequestBody UserVO user) {
		LOGGER.info(" update service");
		return userService.saveUser(user);
	}

	@GetMapping("changepassword/{userId}/{password}")
	public int changePasword(@PathVariable final Long userId, @PathVariable final String password) {
		LOGGER.info(" changepassword service");
		return userService.changePassword(userId, password);
	}

	@GetMapping("approve/{userId}")
	public String approve(@PathVariable final Long userId) {
		LOGGER.info(" approve service");
		userService.approve(userId);
		return "OK";
	}

	@DeleteMapping("delete/{userId}")
	public String delete(@PathVariable final Long userId) {
		LOGGER.info(" delete service");
		return userService.delete(userId);
	}

//	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("all")
	public List<UserVO> findAll() {
		LOGGER.info(" findAll service");
		return userService.findAll();
	}

	@GetMapping("all/{user}")
	public List<UserVO> findAllUser(@PathVariable final String user) {
		LOGGER.info(" findAllUser service");
		return userService.findAllUser(user);
	}

	@GetMapping("roles/{userId}")
	public List<RoleVO> findRoles(@PathVariable final Long userId) {
		LOGGER.info(" findRoles service");
		return userService.findRoles(userId);
	}

	@GetMapping("authorize/{userId}/{roleIds}")
	public String authorize(@PathVariable final Long userId, @PathVariable final String roleIds) {
		LOGGER.info(" authorize service");
		userService.authorize(userId, roleIds);
		return "OK";
	}

	@DeleteMapping("firsttime/{userId}}")
	public String isFirstTime(@PathVariable final Long userId) {
		LOGGER.info(" isFirstTime service");
		int isChanged = userService.getLoggedInStatus(userId);
		if (isChanged == 1) {
			return "OK";
		} else {
			return "NP";
		}
	}


}
