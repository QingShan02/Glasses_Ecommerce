package com.fpoly.controller;

import com.fpoly.entity.Cart;
import com.fpoly.service.CartService;
import com.fpoly.utility.CookieUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CookieUtility cookie;;

	@Autowired
	CartService cartService;

	@GetMapping("/index")
	public String homePage(Model model) {
		List<Cart> cartItems = cartService.getAll();
		model.addAttribute("cartItems", cartItems);
		return "/cart";
	}

	@PostMapping("/save")
	public String saveProduct(Cart cart) {
		cart.setUserId(Integer.parseInt(cookie.getValue("userId")));
		System.out.println(cookie.getValue("userId"));
		cartService.addToCart(cart);
		return "cart";
	}
}
