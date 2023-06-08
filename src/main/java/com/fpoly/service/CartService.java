package com.fpoly.service;

import com.fpoly.entity.Cart;
import com.fpoly.repository.CartRepository;
import com.fpoly.utility.CookieUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CookieUtility cookie;

    @Autowired
    CartRepository cartRepository;

    public void addToCart(Cart cart) {
        Optional<Cart> existingCart = cartRepository.findById(cart.getId());
        System.out.println(cart.toString());
        if (existingCart.isPresent()) {
            existingCart.get().setQuantity(existingCart.get().getQuantity() + cart.getQuantity());
            cartRepository.save(existingCart.get());
        } else {
            cartRepository.save(cart);
        }
    }


    public List<Cart> getAll(Integer userId) {
        return cartRepository.findByUserId(userId);
    }
}