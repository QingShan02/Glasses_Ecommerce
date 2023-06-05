package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.entity.ProductType;
import com.fpoly.repository.ProductTypeRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductTypeRepository pdtResp;

	@GetMapping("/index")
	public String homePage(Model model) {
		return "/index";
	}

	@GetMapping("/contact")
	public String contact() {
		return "/contact";
	}

	@GetMapping("/checkout")
	public String checkout() {
		return "/checkout";
	}

	@GetMapping("/{id}")
	public String sort() {
		return "redirect:/{id}";
	}

	@ModelAttribute("categories")
	public List<ProductType> getCategories() {
		List<ProductType> list = pdtResp.findAll();
		return list;
	}
}
