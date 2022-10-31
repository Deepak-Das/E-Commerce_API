package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.service.category_Service.MainCategoryService;
import com.example.ecommerce.service.category_Service.SubCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("mainCategory/{mainId}/subCategory")
    private ResponseEntity<SubCategoryDto> addSubCat(@PathVariable("mainId") Long mainId, @RequestBody SubCategoryDto subCategoryDto){
        SubCategoryDto subCatDto = subCategoryService.createSubCat(subCategoryDto, mainId);
        return new ResponseEntity<>(subCatDto, HttpStatus.CREATED);
    }

    @PostMapping("subCategory/{subId}")
    private ResponseEntity<SubCategoryDto> updateSubCat(@PathVariable("subId") Long subId, @RequestBody SubCategoryDto subCategoryDto){
        SubCategoryDto subCatDto = subCategoryService.updateSubCat(subCategoryDto,subId);
        return new ResponseEntity<>(subCatDto, HttpStatus.CREATED);
    }

    @GetMapping("subCategory/{subId}")
    private ResponseEntity<SubCategoryDto> getSubCatById(@PathVariable("subId") Long subId){
        SubCategoryDto subCatById = subCategoryService.getSubCatById(subId);
        return new ResponseEntity<>(subCatById,HttpStatus.FOUND);
    }

    @GetMapping("subCategory/{subId}/childCategory")
    private ResponseEntity<Set<ChildCategoryDto>> getChildCatBySubId(@PathVariable("subId") Long subId){
        Set<ChildCategoryDto> childCategoryDtos = subCategoryService.getChildCatBySub(subId);
        return new ResponseEntity<>(childCategoryDtos,HttpStatus.FOUND);
    }

    @DeleteMapping("subCategory/{subId}")
    private ResponseEntity<ApiResponse> deleteSubCat(@PathVariable("subId") Long subId){
        ApiResponse apiResponse = subCategoryService.deleteSubCat(subId);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}