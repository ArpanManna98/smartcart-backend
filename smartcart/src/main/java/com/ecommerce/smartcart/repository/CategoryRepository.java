package com.ecommerce.smartcart.repository;

import com.ecommerce.smartcart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}