package com.atos.feedback.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.ProductService;
import com.atos.feedback.vo.ProductVO;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("dropdown/{domainId}")
	public List<ProductVO> findByDomainId(@PathVariable final Long domainId) {
		return productService.getProductsBuDomain(domainId);
	}

	@GetMapping("all")
	public List<ProductVO> findAll(HttpSession session) {
		return productService.findAll();
	}

	@GetMapping("{productId}")
	public ProductVO find(@PathVariable final Long productId) {
		return productService.findById(productId);
	}

	@PostMapping("add")
	public String add(@RequestBody ProductVO productVO) {
		productService.addProduct(productVO);
		return "OK";
	}

	@DeleteMapping("delete/{productId}")
	public String delete(@PathVariable final Long productId) {
		productService.delete(productId);
		return "OK";
	}

	@PostMapping("rate/{productId}/{rating}")
	public String rateProduct(@PathVariable final Long productId, @PathVariable final int rating) {

		return "OK";
	}
}