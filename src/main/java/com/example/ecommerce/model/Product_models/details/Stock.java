package com.example.ecommerce.model.Product_models.details;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long stockId;

    @Column(nullable = false)
    private int credit;
    @Column(nullable = false)
    private int debate;

    @ManyToOne()
    @JoinColumn(name = "shape_id")
    private  ProductShape shape;
    @ManyToOne()
    @JoinColumn(name = "size_id")
    private ProductSize size;
    @ManyToOne()
    @JoinColumn(name = "color_id")
    private ProductColor color;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,name = "product_id")
    private Product product;






}