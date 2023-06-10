package com.fpoly.controller;

import com.fpoly.utility.CookieUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.entity.Order;
import com.fpoly.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/save")
    public String ordering(Model model, Order order, HttpServletRequest req) {
        orderService.ordering(order);
        req.setAttribute("orderId", order.getId());

        model.addAttribute("orderId", order.getId());

        return "forward:/orderDetail/save";
    }
}
