package com.ecommerce.smartcart.service;

import com.ecommerce.smartcart.dto.CategoryDTO;
import com.ecommerce.smartcart.entity.Category;
import com.ecommerce.smartcart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO saveCategory(CategoryDTO dto) {

        Category category = new Category();
        category.setName(dto.getName());

        Category saved = categoryRepository.save(category);

        CategoryDTO response = new CategoryDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());

        return response;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        return categoryRepository.findAll().stream().map(cat -> {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(cat.getId());
            dto.setName(cat.getName());
            return dto;
        }).collect(Collectors.toList());
    }
}