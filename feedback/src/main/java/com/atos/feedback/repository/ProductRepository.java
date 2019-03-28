package com.atos.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.atos.feedback.model.Domain;
import com.atos.feedback.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByDomain(Domain domain);
	@Override
	List<Product> findAll();
	List<Product> findAllrate(@Param("month") int month, @Param("year") int year);
	@Modifying
	void updateStatus(@Param("productId") Long productId);
}
