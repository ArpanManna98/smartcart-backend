package com.ecommerce.smartcart.controller;

import com.ecommerce.smartcart.dto.ProductDTO;
import com.ecommerce.smartcart.entity.Product;
import com.ecommerce.smartcart.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

	/*
	 * @PostMapping public Product addProduct(@RequestBody Product product) { return
	 * productService.saveProduct(product); }
	 */
    
    @PostMapping
    public ProductDTO addProduct(@Valid @RequestBody ProductDTO dto) {
        return productService.saveProduct(dto);
    }

	/*
	 * @GetMapping public List<ProductDTO> getAllProducts() { return
	 * productService.getAllProducts(); }
	 */
    
    @GetMapping("/paged")
    public List<ProductDTO> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return productService.getProducts(page, size, sortBy);
    }
}