package com.example.ecommerce.model.Product_models.category;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "main_category")
@Setter
@Getter
@NoArgsConstructor
public class MainCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long mainId;

    @Column(length = 20,nullable = false)
    private String mainCategory;

    @OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubCategory> subCategories = new LinkedHashSet<>();

    public MainCategory addSubCategory(SubCategory subCategory){
        this.subCategories.add(subCategory);
        subCategory.setMainCategory(this);
        return this;
    }

    public MainCategory removeSubcategory(SubCategory subCategory){
        this.subCategories.remove(subCategory);
        subCategory.setMainCategory(null);
        return this;
    }

}
