package com.atos.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.DomainService;
import com.atos.feedback.vo.DomainVO;

@RestController
@RequestMapping("domain")
public class DomainController {

	@Autowired
	DomainService domainService;

	@PostMapping("save")
	public DomainVO registerUser(@RequestBody DomainVO vomainVO) {
		return domainService.save(vomainVO);
	}

	@GetMapping("{domainId}")
	public DomainVO findUser(@PathVariable final Long domainId) {
		return domainService.find(domainId);
	}

	@GetMapping("dropdown")
	public List<DomainVO> getDropdownVal() {
		return domainService.findAll();
	}

}
