package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class ProductDetailController {
	@GetMapping
	public String detail() {
		return "detail";
	}
	
	@GetMapping("/{productId}/{productTypeId}")
	public String getById(@PathVariable("productId") Integer productId, @PathVariable("productTypeId") String productTypeId, Model model) {
		
		return "detail";
	}
}
