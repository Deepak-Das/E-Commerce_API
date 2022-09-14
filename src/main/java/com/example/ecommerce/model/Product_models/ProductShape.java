package com.example.ecommerce.model.Product_models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_shape")
@Getter
@Setter
@NoArgsConstructor
public class ProductShape {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long shapeId;

    @Column(nullable = false)
    private String shape;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}