package com.atos.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.ProdRating;

public interface ProductRatingRepository extends CrudRepository<ProdRating, Long> {
	 
}
