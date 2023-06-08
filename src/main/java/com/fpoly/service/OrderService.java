package com.fpoly.service;

import com.fpoly.entity.Order;
import com.fpoly.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void ordering(Order order) {
        order.setStatusId("ST1");
        orderRepository.save(order);
    }
}
