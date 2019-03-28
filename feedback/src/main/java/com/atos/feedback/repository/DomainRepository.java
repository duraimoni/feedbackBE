package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.atos.feedback.model.Domain;
import com.atos.feedback.model.User;

public interface DomainRepository extends CrudRepository<Domain, Long> {
	@Override
	List<Domain> findAll();

	List<Domain> findAllByStatus();
	
	List<Domain> findByUser(@Param("userId") Long userId);

	@Modifying
	void updateStatus(@Param("domainId") Long domainId);
	
}
