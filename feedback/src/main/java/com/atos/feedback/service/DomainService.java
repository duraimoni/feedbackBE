package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.vo.DomainVO;

public interface DomainService {
	DomainVO save(DomainVO domainVo);

	DomainVO find(Long domainId);

	void delete(Long domainId);

	List<DomainVO> findAll();

	List<DomainVO> dropDown();

	String getDomainUser(Long userId);
}
