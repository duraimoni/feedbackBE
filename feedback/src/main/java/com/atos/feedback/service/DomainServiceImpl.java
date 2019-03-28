package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Domain;
import com.atos.feedback.model.User;
import com.atos.feedback.repository.DomainRepository;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.vo.DomainVO;

@Transactional
@Service
public class DomainServiceImpl implements DomainService {

	@Autowired
	DomainRepository domainRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public DomainVO save(DomainVO domainVo) {
		Domain domain = new Domain();
		User user = userRepository.findById(new Long(domainVo.getDomainLeader())).orElse(new User());
		BeanUtils.copyProperties(domainVo, domain);
		domain.setUpdby(1);
		domain.setStatus(1);
		domain.setUser(user);
		domainRepository.save(domain);
		return null;
	}

	@Override
	public DomainVO find(Long domainId) {
		Domain domain = domainRepository.findById(domainId).orElse(new Domain());
		DomainVO domainVo = new DomainVO();
		BeanUtils.copyProperties(domain, domainVo);
		domainVo.setDomainLeader(domain.getUser().getFirstName());
		domainVo.setDomainLeaderId(domain.getUser().getUserId());
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
			domainVO.setDomainLeader(domain.getUser().getFirstName());
			domainVO.setDomainLeaderId(domain.getUser().getUserId());
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

	@Override
	public String getDomainUser(Long userId) {
		List<Domain> domainLst = domainRepository.findByUser(userId);
		String domains = domainLst.stream().map(e -> e.getDomainName()).collect(Collectors.joining(","));
		return domains;
	}

}
