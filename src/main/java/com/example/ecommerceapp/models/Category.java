package com.example.ecommerceapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String name;
    private String description;
    @OneToMany(mappedBy = "category") // to say jpa not to consider the relation twice as it is already defined in product class by category column name
    private List<Product> productList=new ArrayList<>();
}
