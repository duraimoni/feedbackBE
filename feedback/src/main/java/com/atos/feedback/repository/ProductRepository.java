package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.Domain;
import com.atos.feedback.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByDomain(Domain domain);
	 @Override
	 List<Product> findAll();
}
