package com.atos.feedback.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.MailService;
import com.atos.feedback.vo.CustomUserDetails;
import com.atos.feedback.vo.UserVO;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://192.168.99.1:4200")
public class LoginController {

	
	/*
	 * @GetMapping(value = "authenticate", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public String authenticate() { return
	 * "My Rating"; }
	 */
	@GetMapping("authenticate")
	public UserVO user(Principal user, HttpSession session) {
		System.out.println("pind" + user.getName());
		session.setAttribute("username", user.getName());
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		UserVO userVo = new UserVO();
		userVo.setSessionId(session.getId());
		BeanUtils.copyProperties(userDetails, userVo);
		List<String> userRoles = new ArrayList<>();
		userDetails.getRoles().forEach(roleVal -> {
			userRoles.add(roleVal.getRole());
		});
		userVo.setRoles(userRoles);
		return userVo;
	}
	@GetMapping("forgotpassword/{mailId}")
	public String forgotPassword(@PathVariable String mailId) {
	 
		return null;
	}
}
