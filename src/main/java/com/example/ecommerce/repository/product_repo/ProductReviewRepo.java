package com.example.ecommerce.repository.product_repo;

import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepo extends JpaRepository<ProductReview,Long> {
}
