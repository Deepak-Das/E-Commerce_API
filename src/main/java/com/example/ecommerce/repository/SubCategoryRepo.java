package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepo extends JpaRepository<SubCategory,Long> {
}
