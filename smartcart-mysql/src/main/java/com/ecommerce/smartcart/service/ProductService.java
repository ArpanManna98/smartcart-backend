package com.ecommerce.smartcart.service;

import java.util.List;

import com.ecommerce.smartcart.dto.ProductDTO;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO dto);

    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO updateProduct(Long id, ProductDTO dto);
    void deleteProduct(Long id);
}