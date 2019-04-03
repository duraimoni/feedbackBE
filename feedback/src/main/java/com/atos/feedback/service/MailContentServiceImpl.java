package com.atos.feedback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.MailContent;
import com.atos.feedback.repository.MailContentRepository;

@Transactional
@Service
public class MailContentServiceImpl implements MailContentService {

	@Autowired
	MailContentRepository mailContentRepository;

	@Override
	public String save(String content) {
		MailContent mailContent = new MailContent();
		mailContent.setContent(content);
		mailContentRepository.save(mailContent);
		return null;
	}

	@Override
	public String find() {
		List<MailContent> content = mailContentRepository.findAllByOrderByContentIdDesc();
		MailContent mailContent = content.stream().findFirst().orElse(new MailContent());
		return mailContent.getContent();
	}

}
