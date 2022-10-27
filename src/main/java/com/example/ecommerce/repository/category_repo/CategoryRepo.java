package com.example.ecommerce.repository.category_repo;

import com.example.ecommerce.model.Product_models.category.Category;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
