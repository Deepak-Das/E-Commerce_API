package com.example.ecommerce.service.category_Service;

import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.util.ApiResponse;

import java.util.Set;

public interface MainCategoryService {
    public MainCategoryDto createMainCat(MainCategoryDto mainCategoryDto);
    public MainCategoryDto updateMainCat(MainCategoryDto mainCategoryDto,Long mainId);
    public MainCategoryDto getMainCatById(Long mainId);
    public Set<SubCategoryDto> getSubCatByMain(Long mainId);
    public ApiResponse deleteMainCat(Long mainId);

}
