package com.atos.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.feedback.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    ProductService productService;

    /*@PostMapping("add")
    public String addProduct() {
        productService.addProduct();
        return "";
    }

    @PostMapping("update")
    public String updateProduct() {
        productService.updateProduct();
        return "";
    }

    @PostMapping("delete")
    public String deleteProduct() {
        productService.deleteProduct();
        return "";
    }

    @GetMapping("all")
	public List<ProductVO> findAll() {
		return null;
	}*/
}