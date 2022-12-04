package com.example.ecommerce.model.Product_models.details;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

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


    @Formula("credit - debate")
    private int count;


//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "product_id",nullable = false)
//    private Product product;



}