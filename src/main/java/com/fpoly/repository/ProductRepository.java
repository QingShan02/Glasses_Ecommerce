package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//	@Query("SELECT p.")
//	public List<Product> findByType();
}
