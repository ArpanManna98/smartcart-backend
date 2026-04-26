package com.ecommerce.smartcart.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Category name cannot be empty")
    private String name;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}