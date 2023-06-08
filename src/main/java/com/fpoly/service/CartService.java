package com.fpoly.service;

import com.fpoly.entity.Cart;
import com.fpoly.repository.CartRepository;
import com.fpoly.utility.CookieUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CookieUtility cookie;

    @Autowired
    CartRepository cartRepository;

    public void addToCart(Cart cart) {
        Cart existingCart = cartRepository.findByProductDetailId(cart.getProductDetailId());
        existingCart.setUserId(cart.getUserId());
        if (existingCart != null) {
            existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
            cartRepository.save(existingCart);
        } else {
            cartRepository.save(cart);
        }
    }


    public List<Cart> getAll(Integer userId) {
        return cartRepository.findByUserId(userId);
    }
}