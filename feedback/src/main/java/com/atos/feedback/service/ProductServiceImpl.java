package com.atos.feedback.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.AppUser;
import com.atos.feedback.model.Application;
import com.atos.feedback.model.Domain;
import com.atos.feedback.model.Product;
import com.atos.feedback.model.User;
import com.atos.feedback.repository.ProductRepository;
import com.atos.feedback.vo.ProductVO;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductVO addProduct(Product product) {
		Product product = new Product();
		BeanUtils.copyProperties(productVO, product);
		productRepository.add(product);
	}
	/*@Override
    public ProductVO updateProduct(Product product) {
    	
    }
	
    /*@Override
    public ProductVO deleteProduct(Product product) {
    	
    }*/
}