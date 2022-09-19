package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
