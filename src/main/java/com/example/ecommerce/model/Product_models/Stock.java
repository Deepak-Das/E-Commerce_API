package com.example.ecommerce.model.Product_models;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "productId",nullable = false)
    private Product product;



}