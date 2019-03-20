package com.atos.feedback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.atos.feedback.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUserName(String username);

	@Override
	List<User> findAll();
	
	List<User> findAllByStatus();
	
	
	@Modifying
	void updateStatus(@Param("userId") Long userId);
	
	@Modifying
	void deleteUser(@Param("userId") Long userId);
	
	@Modifying
	int changePassword(@Param("userId") Long userId,@Param("password")  String password);
 
}
