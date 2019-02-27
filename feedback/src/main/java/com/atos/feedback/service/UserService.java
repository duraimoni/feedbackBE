package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.vo.UserVO;

public interface UserService {
	UserVO saveUser(UserVO user);

	UserVO findUser(Long userId);

	boolean delete(Long userId);

	List<UserVO> findAll();
}
