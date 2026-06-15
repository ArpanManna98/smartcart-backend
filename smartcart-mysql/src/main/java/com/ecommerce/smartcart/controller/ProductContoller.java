package com.ecommerce.smartcart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.smartcart.dto.ApiResponse;
import com.ecommerce.smartcart.dto.ProductDTO;
import com.ecommerce.smartcart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductContoller {

    private final ProductService productService;

    public ProductContoller(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO saveProduct(
            @Validated @RequestBody ProductDTO dto) {

        return productService.saveProduct(dto);
    }

    @GetMapping
    public Map<String, Object> getAllProducts() {

    	
    	  Map<String, Object> response = new HashMap<>();

    	    response.put("status", true);
    	    response.put("data",  productService.getAllProducts());

    	    return response;
    	
 
    }
    
    @GetMapping("/{id}")
    public ProductDTO getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }
    
    @PutMapping("/{id}")
    public ProductDTO updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO dto) {

        return productService.updateProduct(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return new ApiResponse(
                "Product has been deleted",
                false
        );
    }
}