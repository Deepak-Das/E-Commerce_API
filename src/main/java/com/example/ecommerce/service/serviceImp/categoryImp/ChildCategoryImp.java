package com.example.ecommerce.service.serviceImp.categoryImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.category.ChildCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.repository.category_repo.ChildCategoryRepo;
import com.example.ecommerce.repository.category_repo.SubCategoryRepo;
import com.example.ecommerce.service.category_Service.ChildCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChildCategoryImp implements ChildCategoryService {

    private final ChildCategoryRepo childCategoryRepo;
    private final SubCategoryRepo subCategoryRepo;
    final
    ModelMapper mapper;

    public ChildCategoryImp(ChildCategoryRepo childCategoryRepo, SubCategoryRepo subCategoryRepo, ModelMapper mapper) {
        this.childCategoryRepo = childCategoryRepo;
        this.subCategoryRepo = subCategoryRepo;
        this.mapper = mapper;
    }

    @Override
    public ChildCategoryDto createChildCat(ChildCategoryDto childCategoryDto, Long subId) {
        SubCategory subCategory = subCategoryRepo.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "subId", subId.toString()));
        ChildCategory childCategory = mapper.map(childCategoryDto, ChildCategory.class);
        childCategory.setSubCategory(subCategory);
        ChildCategory save = childCategoryRepo.save(childCategory);
        return mapper.map(save,ChildCategoryDto.class);
    }

    @Override
    public ChildCategoryDto updateChildCat(ChildCategoryDto childCategoryDto,Long childId) {
        ChildCategory childCategory = childCategoryRepo.findById(childId).orElseThrow(() -> new ResourceNotFoundException("Child Category", "childId", childId.toString()));
        childCategory.setChildCategory(childCategoryDto.getChildCategory());
        ChildCategory save = childCategoryRepo.save(childCategory);
        return mapper.map(save,ChildCategoryDto.class);
    }

    @Override
    public ChildCategoryDto childById(Long childId) {
        ChildCategory childCategory = childCategoryRepo.findById(childId).orElseThrow(() -> new ResourceNotFoundException("Child Category", "childId", childId.toString()));
        return mapper.map(childCategory,ChildCategoryDto.class);
    }

    @Override
    public ApiResponse deleteChildCat(Long childId) {
        ChildCategory childCategory = childCategoryRepo.findById(childId).orElseThrow(() -> new ResourceNotFoundException("Child Category", "childId", childId.toString()));
        Long subId=childCategory.getSubCategory().getSubId();
        SubCategory sub = subCategoryRepo.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "subId", subId.toString()));
        SubCategory subCategory = sub.removeChildCategory(childCategory);
        subCategoryRepo.save(subCategory);
        return new ApiResponse("deleted successfully");

    }
}
