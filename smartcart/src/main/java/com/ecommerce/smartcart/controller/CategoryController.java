package com.ecommerce.smartcart.controller;

import com.ecommerce.smartcart.dto.CategoryDTO;
import com.ecommerce.smartcart.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO dto) {
        return categoryService.saveCategory(dto);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
}