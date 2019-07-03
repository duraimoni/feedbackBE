package com.atos.feedback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.RoleService;
import com.atos.feedback.vo.RoleVO;

@RestController
@RequestMapping("roles")
public class RolesController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RoleService roleService;

	@GetMapping("all")
	public List<RoleVO> findAll() {
		LOGGER.info(" findAll service");
		return roleService.findAll();
	}
}
