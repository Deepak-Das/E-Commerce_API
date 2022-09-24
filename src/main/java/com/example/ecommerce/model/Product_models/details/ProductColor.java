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

    @OneToMany(mappedBy = "color" ,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Set<TbOrderDetail> orderDetails=new HashSet<>();

    @OneToMany(mappedBy = "stockId" ,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Stock> stocks=new HashSet<>();


}