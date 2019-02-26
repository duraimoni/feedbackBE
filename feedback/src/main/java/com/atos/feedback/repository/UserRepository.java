package com.atos.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
