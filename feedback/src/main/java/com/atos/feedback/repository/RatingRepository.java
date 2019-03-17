package com.atos.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import com.atos.feedback.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
