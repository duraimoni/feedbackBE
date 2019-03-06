package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.AppUser;
import com.atos.feedback.model.Application;
import com.atos.feedback.model.Domain;
import com.atos.feedback.model.Product;
import com.atos.feedback.model.User;
import com.atos.feedback.repository.AppUserRepository;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.UserVO;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppUserRepository appUserRepository;

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
	public String delete(Long userId) {
		User user = userRepository.findById(userId).orElse(new User());
		user.setStatus(0);
		userRepository.save(user);
		return "OK";
	}

	@Override
	public List<UserVO> findAll() {
		List<User> userLst = userRepository.findAll();
		List<UserVO> domainVoLst = new ArrayList<>();
		userLst.forEach(User -> {
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(User, userVO);
			domainVoLst.add(userVO);
		});
		return domainVoLst;
	}

}
