package com.example.ecommerce.controller;

import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.service.category_Service.ChildCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChildCategoryController {

    @Autowired
    private ChildCategoryService childCategoryService;

    @PostMapping("subCategory/{subId}/childCategory")
    private ResponseEntity<ChildCategoryDto> createChildCategory(@PathVariable("subId") Long subId, @RequestBody ChildCategoryDto dto) {
        ChildCategoryDto childCat = childCategoryService.createChildCat(dto, subId);
        return new ResponseEntity<>(childCat, HttpStatus.CREATED);
    }

    @PutMapping("childCategory/{childId}")
    private ResponseEntity<ChildCategoryDto> updateChildCategory(@PathVariable("childId") Long childId, @RequestBody ChildCategoryDto dto) {
        ChildCategoryDto childCat = childCategoryService.updateChildCat(dto, childId);
        return new ResponseEntity<>(childCat, HttpStatus.CREATED);
    }

    @GetMapping("childCategory/{childId}")
    private ResponseEntity<ChildCategoryDto> getChildById(@PathVariable("childId") Long childId) {
        ChildCategoryDto childCat = childCategoryService.childById(childId);
        return new ResponseEntity<>(childCat, HttpStatus.CREATED);
    }

    @DeleteMapping("childCategory/{childId}")
    private ResponseEntity<ApiResponse> deleteChild(@PathVariable("childId") Long childId) {
        ApiResponse apiResponse = childCategoryService.deleteChildCat(childId);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}
