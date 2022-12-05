package com.example.ecommerce.repository.product_repo;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImageRepo extends JpaRepository<ProductImage,Long> {
    boolean existsByProductAndTypeIgnoreCase(Product product, String type);


}
