package com.fpoly.controller;

import com.fpoly.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/save")
    public String ordering(Model model, Order order) {

        return "redirect:/home/index";
    }
}
