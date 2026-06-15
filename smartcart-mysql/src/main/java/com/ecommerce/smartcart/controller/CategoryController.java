package com.ecommerce.smartcart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ecommerce.smartcart.dto.CategoryDTO;
import com.ecommerce.smartcart.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryDTO saveCategory(@RequestBody CategoryDTO dto) {
        return categoryService.saveCategory(dto);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
}