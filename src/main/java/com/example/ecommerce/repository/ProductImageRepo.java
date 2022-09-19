package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepo extends JpaRepository<ProductImage,Long> {
}
