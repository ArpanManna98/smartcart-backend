package com.ecommerce.smartcart.service;

import java.util.List;

import com.ecommerce.smartcart.dto.CategoryDTO;

public interface CategoryService {

    CategoryDTO saveCategory(CategoryDTO dto);

    List<CategoryDTO> getAllCategories();
}