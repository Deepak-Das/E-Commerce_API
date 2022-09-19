package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepo extends JpaRepository<ProductColor,Long> {
}
