package com.ecommerce.smartcart.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;


public class ProductDTO {
	


	private List<Long> categoryIds;

	public List<Long> getCategoryIds() {
	    return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
	    this.categoryIds = categoryIds;
	}

    private Long id;

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    // Getters & Setters

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}