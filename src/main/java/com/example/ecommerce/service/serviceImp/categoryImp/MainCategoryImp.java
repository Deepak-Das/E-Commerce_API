package com.example.ecommerce.service.serviceImp.categoryImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.repository.category_repo.MainCategoryRepo;
import com.example.ecommerce.repository.category_repo.SubCategoryRepo;
import com.example.ecommerce.service.category_Service.MainCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MainCategoryImp implements MainCategoryService {

    @Autowired
    private MainCategoryRepo mainCategoryRepo;
    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public MainCategoryDto createMainCat(MainCategoryDto mainCategoryDto) {
        MainCategory mainCat = mapper.map(mainCategoryDto, MainCategory.class);

        mainCat.getSubCategories().forEach(subCategory -> {
            subCategory.setMainCategory(mainCat);
            subCategory.getChildCategories().forEach(childCategory -> childCategory.setSubCategory(subCategory));
        });


        MainCategory save = mainCategoryRepo.save(mainCat);

        return mapper.map(save, MainCategoryDto.class);

    }

    @Override
    public MainCategoryDto updateMainCat(MainCategoryDto mainCategoryDto, Long mainId) {
        MainCategory mainCategory = mainCategoryRepo.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main Category", "mainId", mainId.toString()));
        mainCategory.setMainCategory(mainCategoryDto.getMainCategory());
        MainCategory save = mainCategoryRepo.save(mainCategory);
        return mapper.map(save, MainCategoryDto.class);

    }

    @Override
    public MainCategoryDto getMainCatById(Long mainId) {
        MainCategory mainCategory = mainCategoryRepo.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main Category", "mainId", mainId.toString()));
        return mapper.map(mainCategory, MainCategoryDto.class);

    }

    @Override
    public Set<SubCategoryDto> getSubCatByMain(Long mainId) {
        MainCategory mainCategory = mainCategoryRepo.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main Category", "mainId", mainId.toString()));
        Set<SubCategoryDto> subDtos = mainCategory.getSubCategories().stream().map(subCategory -> mapper.map(subCategory, SubCategoryDto.class)).collect(Collectors.toSet());
        return subDtos;
    }

    @Override
    public ApiResponse deleteMainCat(Long mainId) {
        MainCategory mainCategory = mainCategoryRepo.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main Category", "mainId", mainId.toString()));

        mainCategoryRepo.delete(mainCategory);
        return new ApiResponse("Deleted Successfully");
    }
}
