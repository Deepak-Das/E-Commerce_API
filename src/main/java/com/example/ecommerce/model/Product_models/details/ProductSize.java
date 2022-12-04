package com.example.ecommerce.model.Product_models.details;


import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long sizeId;

    @Column(nullable = false)
    private String size;



    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;



    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "stockId")
    private Stock stock;




}