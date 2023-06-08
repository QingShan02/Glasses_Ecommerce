package com.fpoly.controller;

import com.fpoly.entity.Cart;
import com.fpoly.utility.CookieUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CookieUtility cookie;;

	@GetMapping("/cart")
	public String homePage() {
		return "/cart";
	}

	@PostMapping("/save")
	public String saveProduct(Model model, Cart cart) {
		cart.setUserId(Integer.parseInt(cookie.getValue("userId")));
		System.out.println(cookie.getValue("userId"));
		model.addAttribute("cart", cart);
		return "redirect:/home/index";
	}
}
