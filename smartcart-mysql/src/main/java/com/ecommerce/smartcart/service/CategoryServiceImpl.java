package com.ecommerce.smartcart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.smartcart.dto.CategoryDTO;
import com.ecommerce.smartcart.entity.Category;
import com.ecommerce.smartcart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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

        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> dtoList = new ArrayList<>();

        for (Category category : categories) {

            CategoryDTO dto = new CategoryDTO();

            dto.setId(category.getId());
            dto.setName(category.getName());

            dtoList.add(dto);
        }

        return dtoList;
    }
}