package com.example.ecommerce.service.serviceImp.categoryImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.repository.category_repo.MainCategoryRepo;
import com.example.ecommerce.repository.category_repo.SubCategoryRepo;
import com.example.ecommerce.service.category_Service.SubCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

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
    public SubCategoryDto updateSubCat(SubCategoryDto subCategoryDto, Long mainId) {
        return null;
    }

    @Override
    public SubCategoryDto getSubCatById(Long subCatId) {
        return null;
    }

    @Override
    public Set<SubCategoryDto> getSubCatBySub(Long subCatId) {
        return null;
    }

    @Override
    public void deleteSubCat(Long subId) {

    }
}
