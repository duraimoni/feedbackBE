package com.atos.feedback.service;

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
import com.atos.feedback.vo.UserVO;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Override
	public String saveUser(UserVO userVo) {
		
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		User userRet = userRepository.save(user);
		
		AppUser appUser = new AppUser();
		Product product = new Product();
		product.setProductId(1);
		
		Application application = new Application();
		application.setAppId(1);
		
		Domain domain = new Domain();
		domain.setDomainId(1);
		
		appUser.setDomain(domain);
		appUser.setProduct(product);
		appUser.setApplication(application);
		appUser.setUser1(userRet);
		
		
		
		
		//appUser.setUser1(user1);
		appUserRepository.save(appUser);
		//user.setAppUser(appUser);
		//userRepository.save(user);
		return null;
	}

	@Override
	public UserVO findUser(Long userId) {
		User user = userRepository.findById(userId).orElse(new User());
		UserVO userVo = new UserVO();
		userVo.setDomain(user.getAppUser().getDomain().getDomainId());
		user.getAppUser().getProduct().getProductId();
		BeanUtils.copyProperties(user, userVo);
		return userVo;
	}

}
