package com.atos.feedback.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.atos.feedback.model.User;
import com.atos.feedback.repository.SecurityUserRepository;
import com.atos.feedback.vo.CustomUserDetails;

public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private SecurityUserRepository securityUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUsers = securityUserRepository.findByName(username);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
