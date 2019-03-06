package com.atos.feedback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUserName(String username);
	 @Override
	 List<User> findAll();

}
