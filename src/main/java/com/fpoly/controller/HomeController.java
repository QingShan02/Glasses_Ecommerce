package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.entity.ProductType;
import com.fpoly.repository.ProductTypeRepository;
import com.fpoly.service.UserService;
import com.fpoly.utility.CookieUtility;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductTypeRepository pdtResp;
	@Autowired
	CookieUtility cookie;
	@Autowired
	UserService userService;

	@GetMapping("/index")
	public String homePage(Model model) {
		System.out.println(cookie.getValue("userId"));
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
		}
		return "redirect:/home/index";
	}

	@GetMapping("/logout")
	public String logout() {
		userService.logout();
		return "redirect:/home/index";
	}

	@GetMapping("/register")
	public String signup() {
		return "register";
	}

	@ModelAttribute("categories")
	public List<ProductType> getCategories() {
		List<ProductType> list = pdtResp.findAll();
		return list;
	}

	@ModelAttribute("userId")
	public String getUserId() {
		return cookie.getValue("userId");
	}
}
