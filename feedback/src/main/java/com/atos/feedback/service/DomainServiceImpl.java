package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Domain;
import com.atos.feedback.repository.DomainRepository;
import com.atos.feedback.vo.DomainVO;

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
	public void delete(Long domainId) {
		domainRepository.updateStatus(domainId);
	}

	@Override
	public List<DomainVO> findAll() {
		List<Domain> domainLst = domainRepository.findAllByStatus();
		List<DomainVO> domainVoLst = new ArrayList<>();
		domainLst.forEach(domain -> {
			DomainVO domainVO = new DomainVO();
			BeanUtils.copyProperties(domain, domainVO);
			domainVoLst.add(domainVO);
		});
		return domainVoLst;
	}

	@Override
	public List<DomainVO> dropDown() {
		List<Domain> domainLst = domainRepository.findAllByStatus();
		List<DomainVO> domainVoLst = new ArrayList<>();
		domainLst.forEach(domain -> {
			DomainVO domainVO = new DomainVO();
			BeanUtils.copyProperties(domain, domainVO);
			domainVoLst.add(domainVO);
		});
		return domainVoLst;
	}

}
