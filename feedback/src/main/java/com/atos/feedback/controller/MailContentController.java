package com.atos.feedback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.MailContentService;

@RestController
@RequestMapping("mailcontent")
public class MailContentController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	MailContentService mailContentService;

	@GetMapping("get")
	public String getMailContent() {
		LOGGER.info(" getMailContent service");
		return mailContentService.find();
	}

	@PostMapping("add")
	public String addMailContent(@RequestBody String mailCotent) {
		LOGGER.info(" addMailContent service");
		mailContentService.save(mailCotent);
		return "OK";
	}
}
