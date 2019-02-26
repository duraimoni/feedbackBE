package com.atos.feedback.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.User;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String saveUser(UserVO userVo) {
		
		User user = new User();
		userRepository.save(user);
		return null;
	}

	@Override
	public UserVO findUser(Long userId) {
		User user = userRepository.findById(userId).orElse(new User());
		UserVO userVo = new UserVO();
		BeanUtils.copyProperties(user, userVo);
		return userVo;
	}

}
