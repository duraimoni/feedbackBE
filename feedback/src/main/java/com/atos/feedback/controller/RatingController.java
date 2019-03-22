package com.atos.feedback.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.ProductService;
import com.atos.feedback.vo.ProductRateVO;
import com.atos.feedback.vo.ProductVO;

@RestController
@RequestMapping("rating")
public class RatingController {

	@Autowired
	ProductService productService;

	@GetMapping("all")
	public List<ProductVO> findAll(HttpSession session) {
		return productService.findAll(-1l);
	}
	
	@PostMapping("add")
	public String add(@RequestBody ProductRateVO productRateVO) {
		productService.rateProduct(productRateVO);
		return "OK";
	}

}