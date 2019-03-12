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
import com.atos.feedback.vo.ProductVO;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public String addProduct(ProductVO productVo) {
		Product product = new Product();
		productRepository.save(product);
		return null;
	}

	@Override
	public List<ProductVO> getProductsBuDomain(Long domainId) {
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

	@Override
	public ProductVO findById(Long productId) {
		Product product = productRepository.findById(productId).orElse(new Product());
		ProductVO productVo = new ProductVO();
		BeanUtils.copyProperties(product, productVo);
		return productVo;
	}

	@Override
	public void delete(Long productId) {
		productRepository.updateStatus(productId);
	}
}