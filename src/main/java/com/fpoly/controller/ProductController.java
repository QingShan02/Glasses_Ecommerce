package com.fpoly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.fpoly.entity.Product;
import com.fpoly.entity.ProductType;
import com.fpoly.repository.ProductRepository;
import com.fpoly.repository.ProductTypeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	@Autowired
	ProductTypeRepository pdtResp;
	@Autowired
	ProductRepository pdResp;
	@Autowired
	HttpSession session;

	@ModelAttribute("categories")
	public List<ProductType> getCategories() {
		List<ProductType> list = pdtResp.findAll();
		return list;
	}

	@GetMapping("/shop")
	public String homePage(Model model) {
		List<Product> list;
		String ss = (String) session.getAttribute("idProductType");
		if (ss == null) {
			list = pdResp.findAll();
		} else {
			list = pdResp.findByproductTypeId(ss);
			session.removeAttribute("idProductType");
		}
		model.addAttribute("list", list);
		return "/shop";
	}

	@GetMapping("/{id}")
	public String sort(Model model, @PathVariable("id") String id) {
		session.setAttribute("idProductType", id);
		return "forward:/shop";
	}
}
