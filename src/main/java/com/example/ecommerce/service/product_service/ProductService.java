package com.example.ecommerce.service.product_service;

import com.example.ecommerce.model.Product_models.details.ProductImage;
import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.payload.Product.ProductImageDto;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface ProductService {

    public ProductDto createProduct(ProductDto dto,Long sellerId,Long mainId,Long subId,Long childId);
    public ProductDto updateProduct(ProductDto productDto,Long productId);

    public ProductDto productById(Long productId);


    public ApiResponse deleteProduct(Long productId);

    //Todo:update product mainId or subId
    //Todo:product by title/mainCat/subCat/both main & subCat
    //Todo:sort by price/rating

    public ProductImageDto uploadImg(String path, MultipartFile file, Long productId,String type) throws IOException;
    public InputStream downloadImg(String path, String fileName) throws IOException;

    public ApiResponse deleteProductImage(String path ,Long imageId);


}
