package com.atos.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

}
