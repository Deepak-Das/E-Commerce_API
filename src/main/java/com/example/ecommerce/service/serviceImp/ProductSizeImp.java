package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSize;
import com.example.ecommerce.payload.ProductShapeDto;
import com.example.ecommerce.payload.ProductSizeDto;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.repository.ProductShapeRepo;
import com.example.ecommerce.repository.ProductSizeRepo;
import com.example.ecommerce.service.ProductSizeService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSizeImp implements ProductSizeService {
    @Autowired
    private ProductSizeRepo productSizeRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductRepo productRepo;
    @Override
    public ProductSizeDto createPdColor(ProductSizeDto productSizeDto, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        ProductSize pdS = mapper.map(productSizeDto, ProductSize.class);
        pdS.setProduct(product);
        ProductSize save = productSizeRepo.save(pdS);
        return mapper.map(save, ProductSizeDto.class);
    }

    @Override
    public ProductSizeDto updatePdColor(ProductSizeDto productSizeDto, Long sizeId) {
        ProductSize productSize = productSizeRepo.findById(sizeId).orElseThrow(() -> new ResourceNotFoundException("ProductSize", "sizeId", sizeId.toString()));
        productSize.setSize(productSizeDto.getSize());
        ProductSize save = productSizeRepo.save(productSize);
      return mapper.map(save, ProductSizeDto.class);
    }

    @Override
    public ApiResponse delete(Long sizeId) {
        ProductSize productSize = productSizeRepo.findById(sizeId).orElseThrow(() -> new ResourceNotFoundException("ProductSize", "sizeId", sizeId.toString()));
        productSizeRepo.delete(productSize);
        return new ApiResponse("deleted Successfully");
    }
}
