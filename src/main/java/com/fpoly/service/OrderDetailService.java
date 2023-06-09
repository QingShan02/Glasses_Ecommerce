package com.fpoly.service;

import com.fpoly.entity.Order;
import com.fpoly.repository.OrderDetailRepository;
import com.fpoly.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public void save(Integer orderId) {

    }
}
