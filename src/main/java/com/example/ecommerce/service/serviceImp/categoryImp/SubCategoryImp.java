package com.example.ecommerce.service.serviceImp.categoryImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.repository.category_repo.MainCategoryRepo;
import com.example.ecommerce.repository.category_repo.SubCategoryRepo;
import com.example.ecommerce.service.category_Service.SubCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubCategoryImp implements SubCategoryService {

    @Autowired
    private MainCategoryRepo mainCategoryRepo;

    @Autowired
    private SubCategoryRepo subCategoryRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public SubCategoryDto createSubCat(SubCategoryDto subCategoryDto,Long mainId) {
        MainCategory mainCategory = mainCategoryRepo.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main Category", "mainId", mainId.toString()));
        SubCategory subCategory = mapper.map(subCategoryDto, SubCategory.class);
        subCategory.setMainCategory(mainCategory);
        SubCategory save = subCategoryRepo.save(subCategory);
        return mapper.map(save,SubCategoryDto.class);
    }

    @Override
    public SubCategoryDto updateSubCat(SubCategoryDto subCategoryDto,Long subId) {
        SubCategory subCategory = subCategoryRepo.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "subId", subId.toString()));
        subCategory.setSubCategory(subCategoryDto.getSubCategory());
        SubCategory save = subCategoryRepo.save(subCategory);
        return mapper.map(save,SubCategoryDto.class);

    }

    @Override
    public SubCategoryDto getSubCatById(Long subId) {
        SubCategory subCategory = subCategoryRepo.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "subId", subId.toString()));
        return mapper.map(subCategory,SubCategoryDto.class);
    }

    @Override
    public Set<ChildCategoryDto> getChildCatBySub(Long subId) {
        SubCategory subCategory = subCategoryRepo.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "subId", subId.toString()));
        Set<ChildCategoryDto> childDtos = subCategory.getChildCategories().stream().map(childCategory -> mapper.map(childCategory, ChildCategoryDto.class)).collect(Collectors.toSet());
        return childDtos;
    }

    @Override
    public ApiResponse deleteSubCat(Long subId) {
        SubCategory subCategory = subCategoryRepo.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "subId", subId.toString()));
        subCategoryRepo.delete(subCategory);
        return new ApiResponse("deleted successfully");
    }
}
