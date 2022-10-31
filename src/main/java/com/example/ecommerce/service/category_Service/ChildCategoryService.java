package com.example.ecommerce.service.category_Service;

import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.util.ApiResponse;

import java.util.Set;

public interface ChildCategoryService {


    ChildCategoryDto createChildCat(ChildCategoryDto childCategoryDto, Long subId);

    public ChildCategoryDto updateChildCat(ChildCategoryDto childCategoryDto,Long childId);
    public ChildCategoryDto childById(Long childId);
    public ApiResponse deleteChildCat(Long childId);
}
