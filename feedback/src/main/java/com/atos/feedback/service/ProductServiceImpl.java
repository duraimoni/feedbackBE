package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Domain;
import com.atos.feedback.model.Product;
import com.atos.feedback.repository.ProductRepository;
import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.ProductVO;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	/*
	 * @Override public ProductVO addProduct(Product product) { Product product =
	 * new Product(); BeanUtils.copyProperties(productVO, product);
	 * productRepository.add(product); }
	 */
	/*
	 * @Override public ProductVO updateProduct(Product product) {
	 * 
	 * }
	 * 
	 * /*@Override public ProductVO deleteProduct(Product product) {
	 * 
	 * }
	 */

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> getProductsBuDomain(Long domainId) {
		// TODO Auto-generated method stub
		Domain domain = new Domain();
		domain.setDomainId(domainId);
		List<Product> productLst = productRepository.findByDomain(domain);
		List<ProductVO> productVOLst = new ArrayList<>();
		productLst.forEach(product -> {
			ProductVO productVo = new ProductVO();
			BeanUtils.copyProperties(product, productVo);
			productVOLst.add(productVo);
		});
		return productVOLst;
	}

	@Override
	public List<ProductVO> findAll() {
	 
		List<Product> productLst = productRepository.findAll();
		List<ProductVO> productVOLst = new ArrayList<>();
		productLst.forEach(product -> {
			ProductVO productVo = new ProductVO();
			BeanUtils.copyProperties(product, productVo);
			productVOLst.add(productVo);
		});
		return productVOLst;
	}
}