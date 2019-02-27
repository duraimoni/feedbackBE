package com.atos.feedback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Domain;
import com.atos.feedback.repository.DomainRepository;
import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.UserVO;

@Transactional
@Service
public class DomainServiceImpl implements DomainService {

	@Autowired
	DomainRepository domainRepository;

	@Override
	public DomainVO save(DomainVO domainVo) {
		Domain domain = new Domain();
		BeanUtils.copyProperties(domainVo, domain);
		domainRepository.save(domain);
		return null;
	}

	@Override
	public DomainVO find(Long domainId) {
		Domain domain = domainRepository.findById(domainId).orElse(new Domain());
		DomainVO domainVo = new DomainVO();
		BeanUtils.copyProperties(domain, domainVo);
		return domainVo;
	}

	@Override
	public String delete(Long domainId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomainVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
