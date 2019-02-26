package com.atos.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController() {

    @Autowired
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