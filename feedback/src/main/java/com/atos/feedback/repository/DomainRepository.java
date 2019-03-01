package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.Domain;

public interface DomainRepository extends CrudRepository<Domain, Long> {
	 @Override
	 List<Domain> findAll();
}
