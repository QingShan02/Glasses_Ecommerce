package com.fpoly.controller;

import java.util.List;

import com.fpoly.repository.UserRepository;
import com.fpoly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fpoly.entity.ProductType;
import com.fpoly.service.ProductTypeService;

import com.fpoly.entity.ProductType;
import com.fpoly.repository.ProductTypeRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductTypeRepository pdtResp;

	@Autowired
	UserService userService;

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

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		boolean checkLogin = userService.login(username, password);

		if (checkLogin == false) {
			return "login";
		};

		return "redirect:/index";
	}
	@GetMapping("/register")
	public String signup() {
		return "register";
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
