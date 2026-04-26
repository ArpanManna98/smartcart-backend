package com.ecommerce.smartcart.repository;

import com.ecommerce.smartcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}