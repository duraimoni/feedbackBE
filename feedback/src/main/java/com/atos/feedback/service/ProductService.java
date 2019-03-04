package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.model.Product;
import com.atos.feedback.vo.ProductVO;

public interface ProductService {
	String addProduct(Product product);

	/*
	 * String updateProduct(Product product);
	 * 
	 * String deleteProduct(Product product);
	 */
	List<ProductVO> getProductsBuDomain(Long domainId);
}