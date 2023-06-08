package com.fpoly.controller;

import com.fpoly.entity.Cart;
import com.fpoly.service.CartService;
import com.fpoly.utility.CookieUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CookieUtility cookie;

	@Autowired
	CartService cartService;

	@GetMapping("/index")
	public String homePage(Model model) {
		List<Cart> cartItems = cartService.getAll(Integer.parseInt(cookie.getValue("userId")));
		model.addAttribute("cartItems", cartItems);
		return "cart";
	}

	@PostMapping("/save")
	public String saveProduct(Cart cart) {
		Integer userId = Integer.parseInt(cookie.getValue("userId"));
		cart.setUserId(userId);
//		System.out.println(cookie.getValue("userId"));
		cartService.addToCart(cart);
		return "cart";
	}

	@ModelAttribute("totalOrders")
	public double totalOrders() {
		final double[] totalOrders = {0};
		List<Cart> cartItems = cartService.getAll(Integer.parseInt(cookie.getValue("userId")));
		cartItems.stream().forEach(s -> {
			totalOrders[0] += s.getTotal();
		});

		return totalOrders[0];
	}
}
