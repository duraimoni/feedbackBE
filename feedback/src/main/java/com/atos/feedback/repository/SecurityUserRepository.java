package com.atos.feedback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.feedback.model.User;

public interface SecurityUserRepository extends JpaRepository<User, Long>{
	 Optional<User> findByName(String username);
}
