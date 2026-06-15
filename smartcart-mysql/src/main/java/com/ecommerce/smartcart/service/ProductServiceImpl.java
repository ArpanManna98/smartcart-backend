package com.ecommerce.smartcart.service;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.smartcart.entity.Category;
import org.springframework.stereotype.Service;

import com.ecommerce.smartcart.dto.ProductDTO;
import com.ecommerce.smartcart.entity.Product;
import com.ecommerce.smartcart.repository.CategoryRepository;
import com.ecommerce.smartcart.repository.ProductRepository;
import java.util.Optional;
import com.ecommerce.smartcart.exception.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Attach categories
        if (dto.getCategoryIds() != null) {

            product.setCategories(
                new java.util.HashSet<>(
                    categoryRepository.findAllById(dto.getCategoryIds())
                )
            );
        }

        Product saved = productRepository.save(product);

        ProductDTO response = new ProductDTO();

        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setPrice(saved.getPrice());
        response.setDescription(saved.getDescription());

        if (saved.getCategories() != null) {

        	List<Long> categoryIds = saved.getCategories()
        	        .stream()
        	        .map(category -> category.getId())
        	        .toList();

            response.setCategoryIds(categoryIds);
        }

        return response;
    }
    
    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> products =
                productRepository.getAllProductsNative();

        List<ProductDTO> dtoList = new ArrayList<>();

        for(Product product : products) {

            ProductDTO dto = new ProductDTO();

            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setDescription(product.getDescription());

            if(product.getCategories() != null) {

                List<Long> categoryIds = product.getCategories()
                        .stream()
                        .map(category -> category.getId())
                        .toList();

                dto.setCategoryIds(categoryIds);
            }

            dtoList.add(dto);
        }

        return dtoList;
    }
    
    @Override
    public ProductDTO getProductById(Long id) {

    	Product product = productRepository.getProductByIdNative(id);

    	if(product == null) {
    	    throw new ResourceNotFoundException(
    	            "Product not found with id: " + id);
    	}

        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());

        if(product.getCategories() != null) {

            List<Long> categoryIds = product.getCategories()
                    .stream()
                    .map(category -> category.getId())
                    .toList();

            dto.setCategoryIds(categoryIds);
        }

        return dto;
    }
    
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dto) {

        int rowsAffected = productRepository.updateProductNative(
                id,
                dto.getName(),
                dto.getPrice(),
                dto.getDescription());

        if(rowsAffected == 0) {
            throw new ResourceNotFoundException(
                    "Product not found with id: " + id);
        }

        return getProductById(id);
    }
    
    @Override
    public void deleteProduct(Long id) {

    	Product product =
                productRepository.getProductByIdNative(id);

        if(product == null) {
            throw new ResourceNotFoundException(
                    "Product not found with id: " + id);
        }

        productRepository.deleteProductCategoryMappings(id);

        productRepository.deleteProductNative(id);
    }
}


