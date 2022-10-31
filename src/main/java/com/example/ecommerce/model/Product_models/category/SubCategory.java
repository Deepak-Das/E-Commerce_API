package com.example.ecommerce.model.Product_models.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long subId;

    @Column(length = 20)
    private String subCategory;


    @ManyToOne
    @JoinColumn(name = "mainId")
    private MainCategory mainCategory;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ChildCategory> childCategories = new LinkedHashSet<>();

    public SubCategory addChildCategory(ChildCategory childCategory){
        this.childCategories.add(childCategory);
        childCategory.setSubCategory(this);
        return this;
    }

    public SubCategory removeChildCategory(ChildCategory childCategory){
        this.childCategories.remove(childCategory);
        childCategory.setSubCategory(null);
        return this;
    }

}