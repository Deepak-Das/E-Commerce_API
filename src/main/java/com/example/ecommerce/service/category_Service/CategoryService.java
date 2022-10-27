package com.example.ecommerce.service.category_Service;

import com.example.ecommerce.payload.category.CategoryDto;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto getCategory(CategoryDto categoryDto);
    public CategoryDto categoryById(Long catId);


}
