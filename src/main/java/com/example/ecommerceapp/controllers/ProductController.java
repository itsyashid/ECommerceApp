package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.dtos.ProductDto;
import com.example.ecommerceapp.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        Product product=new Product();
        product.setId(id);
        product.setDescription("new product");
        product.setName("Iphone");
        return product;
    }
    @PostMapping
    public Product createProduct(ProductDto product){
        return null;
    }
}
