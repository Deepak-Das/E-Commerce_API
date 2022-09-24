package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.payload.ProductColorDto;
import com.example.ecommerce.repository.ProductColorRepo;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.service.ProductColorService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductColorImp implements ProductColorService {
    @Autowired
    private ProductColorRepo productColorRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductColorDto createPdColor(ProductColorDto productColorDto, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        ProductColor pdC = mapper.map(productColorDto, ProductColor.class);
        pdC.setProduct(product);
        ProductColor save = productColorRepo.save(pdC);
        return mapper.map(save,ProductColorDto.class);
    }

    @Override
    public ProductColorDto updatePdColor(ProductColorDto productColorDto, Long colorId) {
        ProductColor productColor = productColorRepo.findById(colorId).orElseThrow(() -> new ResourceNotFoundException("ProductColor", "colorId", colorId.toString()));
        productColor.setColor(productColorDto.getColor());
        ProductColor save = productColorRepo.save(productColor);
        return mapper.map(save,ProductColorDto.class);
    }

    @Override
    public ApiResponse delete(Long colorId) {
        ProductColor productColor = productColorRepo.findById(colorId).orElseThrow(() -> new ResourceNotFoundException("ProductColor", "colorId", colorId.toString()));
        productColorRepo.delete(productColor);
        return new ApiResponse("deleted Successfully");
    }
}
