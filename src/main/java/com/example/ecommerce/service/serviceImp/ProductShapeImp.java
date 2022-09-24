package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.payload.ProductColorDto;
import com.example.ecommerce.payload.ProductShapeDto;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.repository.ProductShapeRepo;
import com.example.ecommerce.service.ProductShapeService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductShapeImp implements ProductShapeService {
    @Autowired
    private ProductShapeRepo productShapeRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductShapeDto createPdShape(ProductShapeDto productShapeDto, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        ProductShape pdS = mapper.map(productShapeDto, ProductShape.class);
        ProductShape save = productShapeRepo.save(pdS);
        return mapper.map(save, ProductShapeDto.class);
    }

    @Override
    public ProductShapeDto updatePdShape(ProductShapeDto productShapeDto, Long shapeId) {
        ProductShape productShape = productShapeRepo.findById(shapeId).orElseThrow(() -> new ResourceNotFoundException("Product", "shapeId", shapeId.toString()));
        productShape.setShape(productShapeDto.getShape());
        ProductShape save = productShapeRepo.save(productShape);
        return mapper.map(save,ProductShapeDto.class);
    }

    @Override
    public ApiResponse delete(Long shapeId) {
        ProductShape productShape = productShapeRepo.findById(shapeId).orElseThrow(() -> new ResourceNotFoundException("Product", "shapeId", shapeId.toString()));
        productShapeRepo.delete(productShape);
        return new ApiResponse("deleted Successfully");
    }
}
