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
@Table(name = "product_color")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long colorId;

    @Column(nullable = false,length = 20)
    private String color;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}