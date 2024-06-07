package com.example.ecommerceapp.dtos;

import com.example.ecommerceapp.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String description;
    private  String imageUrl;
    private Double price;
    private CategoryDto category;
}
