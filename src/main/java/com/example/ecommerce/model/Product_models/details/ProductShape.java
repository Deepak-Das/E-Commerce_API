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

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "shape" ,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Set<TbOrderDetail> orderDetails=new HashSet<>();

    @OneToMany(mappedBy = "stockId" ,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Set<Stock> stocks=new HashSet<>();

    @OneToMany(mappedBy = "shape" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ProductShape> shapes=new HashSet<>();



}