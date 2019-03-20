package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.atos.feedback.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	
	@Modifying
	void deleteRoles(@Param("userId") Long userId);
	
	List<UserRole> findByUserId(Long userId);
}
