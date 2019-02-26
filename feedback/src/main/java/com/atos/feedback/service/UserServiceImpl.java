package com.atos.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.atos.feedback.model.User;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.vo.UserVO;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String saveUser(UserVO userVo) {
		
		User user = new User();
		userRepository.save(user);
		return null;
	}

}
