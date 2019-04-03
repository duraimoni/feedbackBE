package com.atos.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.RoleService;
import com.atos.feedback.vo.RoleVO;

@RestController
@RequestMapping("roles")
public class RolesController {

	@Autowired
	RoleService roleService;

	@GetMapping("all")
	public List<RoleVO> findAll() {
		return roleService.findAll();
	}
}
