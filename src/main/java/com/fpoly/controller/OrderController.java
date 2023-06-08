package com.fpoly.controller;

import com.fpoly.entity.Order;
import com.fpoly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public String ordering(Model model, Order order) {
//        System.out.println(order.get);
        orderService.ordering(order);
        return "redirect:/home/index";
    }
}
