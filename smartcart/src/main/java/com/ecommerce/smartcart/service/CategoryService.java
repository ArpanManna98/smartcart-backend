package com.ecommerce.smartcart.service;

import com.ecommerce.smartcart.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

    CategoryDTO saveCategory(CategoryDTO dto);

    List<CategoryDTO> getAllCategories();
}