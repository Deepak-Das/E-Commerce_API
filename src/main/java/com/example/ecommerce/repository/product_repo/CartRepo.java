package com.example.ecommerce.repository.product_repo;

import com.example.ecommerce.model.Product_models.Cart;
import com.example.ecommerce.model.Product_models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Long> {
}
