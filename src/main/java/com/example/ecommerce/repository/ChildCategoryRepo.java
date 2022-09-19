package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.category.Category;
import com.example.ecommerce.model.Product_models.category.ChildCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildCategoryRepo extends JpaRepository<ChildCategory,Long> {
}
