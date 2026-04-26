/*
 * package com.ecommerce.smartcart.service;
 * 
 * import com.ecommerce.smartcart.entity.Product; import
 * com.ecommerce.smartcart.repository.ProductRepository; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import java.util.List;
 * 
 * @Service public class ProductServiceImpl implements ProductService {
 * 
 * @Autowired private ProductRepository productRepository;
 * 
 * @Override public Product saveProduct(Product product) { return
 * productRepository.save(product); }
 * 
 * @Override public List<Product> getAllProducts() { return
 * productRepository.findAll(); } }
 */

package com.ecommerce.smartcart.service;

import com.ecommerce.smartcart.dto.ProductDTO;
import com.ecommerce.smartcart.entity.Product;
import com.ecommerce.smartcart.repository.CategoryRepository;
import com.ecommerce.smartcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // DTO → Entity → Save → DTO
    @Override
    public ProductDTO saveProduct(ProductDTO dto) {

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        if (dto.getCategoryIds() != null) {
            product.setCategories(
                new HashSet<>(categoryRepository.findAllById(dto.getCategoryIds()))
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

        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> {

            ProductDTO dto = new ProductDTO();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setDescription(product.getDescription());

            if (product.getCategories() != null) {
                List<Long> categoryIds = product.getCategories()
                        .stream()
                        .map(category -> category.getId())
                        .toList();

                dto.setCategoryIds(categoryIds);
            }

            return dto;

        }).toList();
    }
}