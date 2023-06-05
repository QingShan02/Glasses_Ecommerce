package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpoly.entity.ProductType;
import com.fpoly.service.ProductTypeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductTypeService service;
	
	@GetMapping("/index")
	public String homePage() {
//		System.out.println(service.getAll().toString());
		return "index";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@ModelAttribute("list")
	public List<ProductType> list() {
		return service.getAll();
	}
	
}
