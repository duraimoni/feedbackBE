package com.atos.feedback.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.DomainService;
import com.atos.feedback.service.UserService;
import com.atos.feedback.vo.CustomUserDetails;
import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.UserVO;

@RestController
@RequestMapping("login")
//@CrossOrigin(origins = "http://192.168.99.1:4200")
public class LoginController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	/*
	 * @GetMapping(value = "authenticate", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public String authenticate() { return
	 * "My Rating"; }
	 */
	@Autowired
	UserService userService;
	@Autowired
	DomainService domainService;
	@GetMapping("authenticate")
	public UserVO user(Principal user, HttpSession session) {
		LOGGER.info("user authenticate service");
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
		userVo.setChangePassword(userService.getLoggedInStatus(userVo.getUserId()));
		userVo.setRoles(userRoles);
		return userVo;
	}

	@PostMapping("forgotpassword")
	public String resetPassword(@RequestBody String mailId) {
		LOGGER.info(" forgotpassword service");
		String retVal = userService.forgotPassword(mailId);
		return retVal;
	}
	@PostMapping("test")
	public DomainVO testDomain(@RequestBody DomainVO domainVO) {
		System.out.println("rathakrishnn");
		domainVO = new DomainVO();
		domainVO.setDomainDesc("rathakr:s");
		return domainVO;
	}
	@GetMapping("dropdown")
	public List<DomainVO> getDropdownVal(HttpSession session) {
		LOGGER.info("getDropdownVal service");
		return domainService.findAll();
	}
}
