package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Role;
import com.atos.feedback.repository.RoleRepository;
import com.atos.feedback.vo.RoleVO;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<RoleVO> findAll() {
		List<Role> roleLSt = roleRepository.findAll();
		List<RoleVO> roleVoLst = new ArrayList<>();
		roleLSt.forEach(role -> {
			RoleVO roleVo = new RoleVO();
			BeanUtils.copyProperties(role, roleVo);
			roleVoLst.add(roleVo);
		});
		return roleVoLst;
	}
}