package com.example.ecommerce.controller;

import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.payload.Product.ProductImageDto;
import com.example.ecommerce.service.product_service.ProductService;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController()
@RequestMapping("products/")
public class ProductController {

    @Value("${project.image}")
    private String path;

    @Autowired
    private ProductService productService;

    @PostMapping({
            "seller/{sellerId}/main/{mainId}/sub/{subId}/child/{childId}",
            "seller/{sellerId}/main/{mainId}/sub/{subId}/"
    })
    ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto,
            @PathVariable("sellerId") Long sellerId,
            @PathVariable("mainId") Long mainId,
            @PathVariable("subId") Long subId,
            @PathVariable(value = "childId", required = false) Long childId
    ) {
        //Todo : need categoryId
        ProductDto product = productService.createProduct(productDto, sellerId, mainId, subId, childId);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @GetMapping("{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long productId) {
        ProductDto productDto = productService.productById(productId);
        return new ResponseEntity<>(productDto, HttpStatus.FOUND);
    }

    @DeleteMapping("{productId}")
    ResponseEntity<ApiResponse> deletePro(@PathVariable("productId") Long productId) {
        ApiResponse apiResponse = productService.deleteProduct(productId);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{productId}/image")
    private ResponseEntity<ProductImageDto> productImageUpload(
            @PathVariable("productId") Long productId,
            @RequestParam("type") String type,
            @RequestParam("image") MultipartFile file) throws IOException {

        ProductImageDto imageDto = productService.uploadImg(path, file, productId, type);

        return ResponseEntity.ok(imageDto);
    }

    @GetMapping("image/{imageName}")
    private void downloadImage(
            @PathVariable("imageName") String imageName,
            ServletResponse response
    ) throws IOException {

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        InputStream inputStream = productService.downloadImg(path, imageName);
        StreamUtils.copy(inputStream, response.getOutputStream());

    }

    @DeleteMapping("image/{imageId}")
    private ResponseEntity<ApiResponse> deleteImage(
            @PathVariable("imageId") Long imageId
            ) throws IOException {

        ApiResponse apiResponse = productService.deleteProductImage(path, imageId);
        return ResponseEntity.ok(apiResponse);
    }
}
