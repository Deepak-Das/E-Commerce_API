package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductShapeRepo extends JpaRepository<ProductShape,Long> {
}
