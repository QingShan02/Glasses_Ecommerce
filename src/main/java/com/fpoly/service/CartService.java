package com.fpoly.service;

import com.fpoly.entity.Cart;
import com.fpoly.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public void addToCart(Cart cart) {
        Cart existingCart = cartRepository.findByProductDetailId(cart.getProductDetailId());
        if (existingCart != null) {
            System.out.println(existingCart);
            existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
            cartRepository.save(existingCart);
        } else {
            cartRepository.save(cart);
        }
    }


    public List<Cart> getAll() {
        return cartRepository.findAll();
    }
}