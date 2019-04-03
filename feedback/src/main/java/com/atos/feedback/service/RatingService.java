package com.atos.feedback.service;

import java.util.List;

import com.atos.feedback.vo.RatingAllVO;

public interface RatingService {

	List<RatingAllVO> findAllRatings();
 
}