package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
