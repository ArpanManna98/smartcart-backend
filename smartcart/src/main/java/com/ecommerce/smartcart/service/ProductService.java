package com.ecommerce.smartcart.service;

import java.util.List;

import com.ecommerce.smartcart.dto.ProductDTO;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO dto);

    List<ProductDTO> getAllProducts();
}