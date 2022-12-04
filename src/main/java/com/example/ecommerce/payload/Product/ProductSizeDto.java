package com.example.ecommerce.payload.Product;


import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.Stock;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
import com.example.ecommerce.payload.StockDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class ProductSizeDto {
    private Long sizeId;

    private String size;

    private StockDto stock;


//    private Product product;

//    private Set<TbOrderDetail> orderDetails=new HashSet<>();

//    private Set<Stock> stocks=new HashSet<>();




}