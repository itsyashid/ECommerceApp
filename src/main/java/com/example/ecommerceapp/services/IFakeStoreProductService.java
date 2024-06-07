package com.example.ecommerceapp.services;

import com.example.ecommerceapp.models.Product;

import java.util.List;

public interface IFakeStoreProductService {
    List<Product> getAllProduct();

    Product getProductById(Long id);

    Product createProduct(Product product);
}
