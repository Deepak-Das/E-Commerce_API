package com.example.ecommerce.model.Product_models.category;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long catId;

    @OneToOne()
    @JoinColumn(name = "main_id", referencedColumnName = "mainId")
    private MainCategory mainCategory;
    @OneToOne()
    @JoinColumn(name = "sub_id", referencedColumnName = "subId")
    private SubCategory subCategory;
    @OneToOne()
    @JoinColumn(name = "child_id", referencedColumnName = "ChildId")
    private ChildCategory childCategory;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



}