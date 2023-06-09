package com.fpoly.service;

import com.fpoly.entity.Order;
import com.fpoly.repository.OrderRepository;
import com.fpoly.repository.UserRepository;
import com.fpoly.utility.CookieUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CookieUtility cookie;

    public void ordering(Order order) {
        Integer userId = Integer.parseInt(cookie.getValue("userId"));
        String address = userRepository.findById(userId).get().getAddress();

        order.setUserId(userId);
        order.setShippingAddress(address);
        order.setPaymentmethodId(1);
        order.setStatusId("ST1");

        orderRepository.save(order);
    }
}
