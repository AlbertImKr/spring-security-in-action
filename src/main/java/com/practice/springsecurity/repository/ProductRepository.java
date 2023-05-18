package com.practice.springsecurity.repository;

import com.practice.springsecurity.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
