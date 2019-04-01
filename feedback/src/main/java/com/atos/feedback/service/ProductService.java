package com.atos.feedback.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.atos.feedback.vo.ProductRateVO;
import com.atos.feedback.vo.ProductVO;

public interface ProductService {
	String addProduct(ProductVO productVo);

	/*
	 * String updateProduct(Product product);
	 * 
	 * String deleteProduct(Product product);
	 */
	List<ProductVO> getProductsBuDomain(Long domainId, Long userId);

	ProductVO findById(Long productId);

	List<ProductVO> findAll(Long userId);

	void delete(Long productId);

	void rateProduct(ProductRateVO productRateVO);
	
	ByteArrayInputStream exportProduct(Long userId) throws IOException;
}