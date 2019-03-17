package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.model.Product;
import com.atos.feedback.vo.ProductVO;

public interface RatingService {
	 

	List<ProductVO> findAll();
 
}