package com.example.ecommerce.payload.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
public class ChildCategoryDto {
    private Long childId;

    private String childCategory;

}