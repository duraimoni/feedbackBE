package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.UserVO;

public interface DomainService {
	DomainVO save(DomainVO domainVo);

	DomainVO find(Long domainId);

	String delete(Long domainId);

	List<DomainVO> findAll();
	
	List<DomainVO> dropDown();
}
