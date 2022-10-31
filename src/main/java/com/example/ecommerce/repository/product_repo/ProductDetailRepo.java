package com.example.ecommerce.repository.product_repo;

import com.example.ecommerce.model.Product_models.details.ProductReview;
import com.example.ecommerce.model.Product_models.details.ProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepo extends JpaRepository<ProductSpec,Long> {
}
