package com.atos.feedback.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.DomainService;
import com.atos.feedback.vo.DomainVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("domain")
public class DomainController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DomainService domainService;

	@PostMapping("add")
	public DomainVO addDomain(@RequestBody DomainVO domainVO) {
		LOGGER.info("addDomain service");
		return domainService.save(domainVO);
	}

	@DeleteMapping("delete/{domainId}")
	public String deleteDomain(@PathVariable final Long domainId) {
		LOGGER.info("deleteDomain service");
		domainService.delete(domainId);
		return "OK";
	}
	
	@GetMapping("{domainId}")
	public DomainVO findUser(@PathVariable final Long domainId) {
		LOGGER.info("findUser service");
		return domainService.find(domainId);
	}

	@GetMapping("dropdown")
	public List<DomainVO> getDropdownVal(HttpSession session) {
		LOGGER.info("getDropdownVal service");
		return domainService.findAll();
	}
	@GetMapping("user/{userId}")
	public String getDominUser(@PathVariable final Long userId) {
		LOGGER.info("getDominUser service");
		return domainService.getDomainUser(userId);
	}

	
}
