package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.category.ChildCategory;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCategoryRepo extends JpaRepository<MainCategory,Long> {
}
