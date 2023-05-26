package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {
	@GetMapping("/detail")
	public String homePage() {
		return "detail";
	}
}
