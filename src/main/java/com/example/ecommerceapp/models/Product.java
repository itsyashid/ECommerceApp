package com.example.ecommerceapp.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String name;
    private String description;
    private  String imageUrl;
    private Double price;
    @ManyToOne(cascade = CascadeType.ALL) // to create category if not there while creating product
    private Category category;
}
