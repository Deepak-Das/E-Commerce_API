package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeRepo extends JpaRepository<ProductSize,Long> {
}
