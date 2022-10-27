package com.example.ecommerce.service.category_Service;

import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;

import java.util.Set;

public interface SubCategoryService {

    public SubCategoryDto createSubCat(SubCategoryDto subCategoryDto,Long mainId);
    public SubCategoryDto updateSubCat(SubCategoryDto subCategoryDto,Long mainId);
    public SubCategoryDto getSubCatById(Long subCatId);
    public Set<SubCategoryDto> getSubCatBySub(Long subCatId);
    void deleteSubCat(Long subId);
}
