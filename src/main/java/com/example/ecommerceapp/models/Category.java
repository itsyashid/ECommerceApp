package com.example.ecommerceapp.models;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseModel{
    private String name;
    private String description;
    private List<Product> productList=new ArrayList<>();
}
