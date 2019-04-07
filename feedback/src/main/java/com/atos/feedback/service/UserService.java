package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.vo.RoleVO;
import com.atos.feedback.vo.UserVO;

public interface UserService {
	UserVO saveUser(UserVO user);

	UserVO findUser(Long userId);

	String delete(Long userId);

	List<UserVO> findAll();

	String approve(Long userId);

	List<RoleVO> findRoles(Long userId);

	String authorize(Long userId, String roleIds);

	int changePassword(Long userId, String password);

	List<String> getCurrentUserRoles(Long userId);

	boolean isAdmin(List<String> roleLst);

	boolean isProductLead(List<String> roleLst);

	List<UserVO> findAllUser(final String userVal);
	
	String forgotPassword(String mailId);
}
