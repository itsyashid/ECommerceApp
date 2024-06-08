package com.example.ecommerceapp.services;

import com.example.ecommerceapp.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(Long id,Product product);
}