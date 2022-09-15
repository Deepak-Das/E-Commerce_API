package com.example.ecommerce.model.Product_models;

import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSize;
import com.example.ecommerce.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long cartId;

    @Column(nullable = false)
    private int itemCount;

    @ManyToOne
    @JoinColumn(name = "shape_id")
    private ProductShape shape;
    @ManyToOne
    @JoinColumn(name = "size_id")
    private ProductSize size;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ProductColor color;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}