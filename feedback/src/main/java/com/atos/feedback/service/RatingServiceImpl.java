package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Rating;
import com.atos.feedback.repository.RatingRepository;
import com.atos.feedback.vo.RatingAllVO;

@Transactional
@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public List<RatingAllVO> findAllRatings() {
		List<RatingAllVO> retLst = new ArrayList<>();
		List<Rating> ratingLst = ratingRepository.findAll();
		ratingLst.forEach(rating -> {
			RatingAllVO ratingAllVO = new RatingAllVO();
			BeanUtils.copyProperties(rating, ratingAllVO);
			retLst.add(ratingAllVO);
		});
		return retLst;
	}
}