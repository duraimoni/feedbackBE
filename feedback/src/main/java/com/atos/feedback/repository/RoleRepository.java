package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	@Override
	List<Role> findAll();

}
