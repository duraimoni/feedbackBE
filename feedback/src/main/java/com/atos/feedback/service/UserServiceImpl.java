package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atos.feedback.model.AppUser;
import com.atos.feedback.model.Application;
import com.atos.feedback.model.Domain;
import com.atos.feedback.model.Product;
import com.atos.feedback.model.Role;
import com.atos.feedback.model.User;
import com.atos.feedback.model.UserRole;
import com.atos.feedback.repository.AppUserRepository;
import com.atos.feedback.repository.RoleRepository;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.repository.UserRoleRepository;
import com.atos.feedback.vo.RoleVO;
import com.atos.feedback.vo.UserVO;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppUserRepository appUserRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserVO saveUser(UserVO userVo) {

		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		User userRet = userRepository.save(user);
		AppUser appUser = null;
		if (userRet.getAppUser() == null) {
			appUser = new AppUser();
			Product product = new Product();
			product.setProductId(1l);
			Application application = new Application();
			application.setAppId(1);
			Domain domain = new Domain();
			domain.setDomainId(1l);
			appUser.setDomain(domain);
			appUser.setProduct(product);
			appUser.setApplication(application);
			appUser.setUser1(userRet);
		} else {
			appUser = userRet.getAppUser();
		}
		appUserRepository.save(appUser);

		return findUser(userRet.getUserId());
	}

	@Override
	public UserVO findUser(Long userId) {
		User user = userRepository.findById(userId).orElse(new User());
		UserVO userVo = new UserVO();
		BeanUtils.copyProperties(user, userVo);
		if (user.getAppUser() != null) {
			userVo.setDomain(user.getAppUser().getDomain().getDomainId());
			userVo.setProduct(user.getAppUser().getProduct().getProductId());
		}
		return userVo;
	}

	@Override
	@ResponseBody
	public String delete(Long userId) {
		userRepository.deleteUser(userId);
		return "OK";
	}

	@Override
	public List<UserVO> findAll() {
		List<User> userLst = userRepository.findAllByStatus();
		List<UserVO> userVoLst = new ArrayList<>();
		userLst.forEach(user -> {
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(user, userVO);
			userVoLst.add(userVO);
			List<String> userRoles = new ArrayList<>();
			user.getRoles().forEach(roleVal -> {
				userRoles.add(roleVal.getRole());
			});
			userVO.setRoles(userRoles);
		});
		return userVoLst;
	}

	@Override
	public String approve(Long userId) {
		userRepository.updateStatus(userId);
		return "OK";
	}

	private List<Long> getRoleIds(Long userId) {
		List<Long> retLst = new ArrayList<>();
		List<UserRole> userRoleLst = userRoleRepository.findByUserId(userId);
		userRoleLst.forEach(userRole -> {
			retLst.add(userRole.getRoleId());
		});
		return retLst;
	}

	@Override
	public List<RoleVO> findRoles(Long userId) {
		List<Role> roleLst = roleRepository.findAll();
		List<Long> roleIdLs = getRoleIds(userId);
		List<RoleVO> roleVoLst = new ArrayList<>();
		roleLst.forEach(role -> {
			RoleVO roleVO = new RoleVO();
			BeanUtils.copyProperties(role, roleVO);
			if (roleIdLs.contains(role.getRoleId())) {
				roleVO.setAssigned(true);
			} else {
				roleVO.setAssigned(false);
			}

			roleVoLst.add(roleVO);
		});
		return roleVoLst;
	}

	@Override
	public String authorize(Long userId, String roleIds) {
		List<String> roldIds = Arrays.asList(roleIds.split("\\s*,\\s*"));
		userRoleRepository.deleteRoles(userId);
		roldIds.forEach(val -> {
			UserRole userrole = new UserRole();
			userrole.setUserId(userId);
			userrole.setRoleId(new Long(val));
			userRoleRepository.save(userrole);
		});
		return null;
	}

	@Override
	public int changePassword(Long userId, String password) {
		return  userRepository.changePassword(userId, password);
	}

}
