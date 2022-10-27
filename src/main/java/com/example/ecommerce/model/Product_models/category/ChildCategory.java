package com.example.ecommerce.model.Product_models.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "child_category")
public class ChildCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long childId;

    @Column(length = 10,nullable = false)
    private String childCategory;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_cat_id",nullable = false)
    private SubCategory subCategory;

}