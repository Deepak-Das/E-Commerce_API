package com.example.ecommerce.payload.category;

import com.example.ecommerce.util.ResponseView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

public class SubCategoryDto {
    private Long subId;

    private String subCategory;

    private Set<ChildCategoryDto> childCategories = new HashSet<>();

}