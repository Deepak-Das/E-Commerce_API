package com.example.ecommerce.service.category_Service;

import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.util.ApiResponse;

import java.util.Set;

public interface SubCategoryService {

    public SubCategoryDto createSubCat(SubCategoryDto subCategoryDto,Long mainId);
    public SubCategoryDto updateSubCat(SubCategoryDto subCategoryDto, Long subId);
    public SubCategoryDto getSubCatById(Long subId);
    public Set<ChildCategoryDto> getChildCatBySub(Long subId);
    public ApiResponse deleteSubCat(Long subId);
}
