package com.example.ecommerce.payload;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.Stock;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductShapeDto {

    private Long shapeId;

    private String shape;







}