package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.entity.ProductType;
import com.fpoly.service.ProductService;
import com.fpoly.service.ProductTypeService;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/shop")
public class ProductController {
	@Autowired
	ProductTypeService productTypeService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	public String shop(@PathParam("id") String id) {
		return "shop";
	}
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("products", productService.getAll());
		return "shop";
	}
	
	@ModelAttribute("list")
	public List<ProductType> list() {
		return productTypeService.getAll();
	}
}
