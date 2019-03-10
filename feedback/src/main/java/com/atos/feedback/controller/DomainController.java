package com.atos.feedback.controller;

import java.util.List;

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

@RestController
@RequestMapping("domain")
public class DomainController {

	@Autowired
	DomainService domainService;

	@PostMapping("add")
	public DomainVO addDomain(@RequestBody DomainVO domainVO) {
		return domainService.save(domainVO);
	}

	@DeleteMapping("delete/{domainId}")
	public String deleteDomain(@PathVariable final Long domainId) {
		domainService.delete(domainId);
		return "OK";
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
