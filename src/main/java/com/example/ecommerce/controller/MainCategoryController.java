package com.example.ecommerce.controller;

import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.example.ecommerce.service.category_Service.MainCategoryService;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MainCategoryController {
    @Autowired
    private MainCategoryService mainCategoryService;

    @PostMapping("mainCategory")
    private ResponseEntity<MainCategoryDto> creatMainCategoryDto(@RequestBody MainCategoryDto dto){
        return new ResponseEntity<>(mainCategoryService.createMainCat(dto),HttpStatus.CREATED);

    }
    @PutMapping("mainCategory/{mainId}")
    private ResponseEntity<MainCategoryDto> updateMainCategoryDto(@RequestBody MainCategoryDto dto,@PathVariable("mainId") Long mainId ){
        return new ResponseEntity<>(mainCategoryService.updateMainCat(dto,mainId),HttpStatus.CREATED);

    }


    @GetMapping("mainCategory/{mainId}")
    private ResponseEntity<MainCategoryDto> getById(@PathVariable("mainId") Long mainId){
        MainCategoryDto mainCat = mainCategoryService.getMainCatById(mainId);
        return new ResponseEntity<>(mainCat, HttpStatus.FOUND);
    }

    @GetMapping("mainCategory/{mainId}/subCategory")
    private ResponseEntity<Set<SubCategoryDto>> getSubByMainId(@PathVariable("mainId") Long mainId){
        Set<SubCategoryDto> subCategoryDtos= mainCategoryService.getSubCatByMain(mainId);
        return new ResponseEntity<>(subCategoryDtos,HttpStatus.OK);
    }

    @DeleteMapping("mainCategory/{mainId}")
    private  ResponseEntity<ApiResponse> deleteMain(@PathVariable("mainId") Long mainId){
        ApiResponse apiResponse = mainCategoryService.deleteMainCat(mainId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
}
