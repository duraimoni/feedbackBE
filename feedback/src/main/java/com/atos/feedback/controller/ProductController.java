package com.atos.feedback.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("dropdown/{domainId}/{userId}")
	public List<ProductVO> findByDomainId(@PathVariable final Long domainId, @PathVariable final Long userId) {
		return productService.getProductsBuDomain(domainId, userId);
	}

	@GetMapping("all/{userId}")
	public List<ProductVO> findAll(HttpSession session, @PathVariable final Long userId) {
		System.out.println("session in login Value:>" + session.getId() + "--" + session.getAttribute("username"));
		return productService.findAll(userId);
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

	@GetMapping("export/{userId}")
	public ResponseEntity<InputStreamResource> export(@PathVariable final Long userId, HttpServletResponse response) throws IOException {
		ByteArrayInputStream in = productService.exportProduct(userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}