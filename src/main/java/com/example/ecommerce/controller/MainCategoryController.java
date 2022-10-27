package com.example.ecommerce.controller;

import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.service.category_Service.MainCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainCategoryController {
    @Autowired
    private MainCategoryService mainCategoryService;

    @PostMapping("mainCategory")
    private ResponseEntity<MainCategoryDto> creatMainCategoryDto(@RequestBody MainCategoryDto dto){
        return new ResponseEntity<>(mainCategoryService.createMainCat(dto),HttpStatus.CREATED);

    }

    @GetMapping("mainCategory/{mainId}")
    private ResponseEntity<MainCategoryDto> getById(@PathVariable("mainId") Long mainId){
        MainCategoryDto mainCat = mainCategoryService.getMainCatById(mainId);
        return new ResponseEntity<>(mainCat, HttpStatus.FOUND);
    }

    @DeleteMapping("mainCategory/{mainId}")
    private  ResponseEntity<ApiResponse> deleteMain(@PathVariable("mainId") Long mainId){
        ApiResponse apiResponse = mainCategoryService.deleteMainCat(mainId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
}
