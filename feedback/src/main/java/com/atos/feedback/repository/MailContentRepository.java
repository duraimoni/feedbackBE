package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.MailContent;

public interface MailContentRepository extends CrudRepository<MailContent, Long> {
	@Override
	List<MailContent> findAll();
}
