package com.ecommerce.smartcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.smartcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Native SQL Query
    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> getAllProductsNative();
    
    @Query(value = "SELECT * FROM product WHERE id = :id", nativeQuery = true)
    Product getProductByIdNative(@Param("id") Long id);
    
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE product
            SET name = :name,
                price = :price,
                description = :description
            WHERE id = :id
            """, nativeQuery = true)
    int updateProductNative(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("price") double price,
            @Param("description") String description);
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product WHERE id = :id", nativeQuery = true)
    int deleteProductNative(@Param("id") Long id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_category WHERE product_id = :id",
           nativeQuery = true)
    void deleteProductCategoryMappings(@Param("id") Long id);

}