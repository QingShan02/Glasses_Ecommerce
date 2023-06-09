package com.fpoly.controller;

import com.fpoly.entity.Cart;
import com.fpoly.entity.Order;
import com.fpoly.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/save")
    public String save(Model model, Cart cart) {
        Integer orderId = (Integer) model.getAttribute("orderId");


        return "redirect:/home/index";
    }
}
