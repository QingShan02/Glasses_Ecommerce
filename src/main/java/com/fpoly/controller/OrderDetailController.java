package com.fpoly.controller;

import com.fpoly.entity.Cart;
import com.fpoly.entity.Order;
import com.fpoly.repository.CartRepository;
import com.fpoly.service.OrderDetailService;
import com.fpoly.utility.CookieUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CookieUtility cookie;

    @PostMapping("/save")
    public String save(Model model, HttpServletRequest req) {
        Integer userId = Integer.parseInt(cookie.getValue("userId"));
        Integer orderId = (Integer) req.getAttribute("orderId");

        List<Cart> carts = cartRepository.findByUserId(userId);
        orderDetailService.saveAll(orderId, carts);

        return "redirect:/home/index";
    }
}
