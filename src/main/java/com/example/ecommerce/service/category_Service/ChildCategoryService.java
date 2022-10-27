package com.example.ecommerce.service.category_Service;

import com.example.ecommerce.payload.category.SubCategoryDto;

import java.util.Set;

public interface ChildCategoryService {

    public SubCategoryDto createMainCat(SubCategoryDto ChildCategoryDto);
    public SubCategoryDto updateMainCat(SubCategoryDto ChildCategoryDto,Long mainId);
    public Set<SubCategoryDto> getChildCatBySub(Long ChildId);
    void deleteChildCat(Long subCatId);
}
