package com.atos.feedback.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.User;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.vo.CustomUserDetails;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByUserName(username);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
