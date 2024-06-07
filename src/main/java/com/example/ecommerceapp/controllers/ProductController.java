package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.dtos.CategoryDto;
import com.example.ecommerceapp.dtos.ProductDto;
import com.example.ecommerceapp.models.Product;
import com.example.ecommerceapp.services.IFakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    IFakeStoreProductService iFakeStoreProductService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
//        Product product=new Product();
//        product.setId(id);
//        product.setDescription("new product");
//        product.setName("Iphone");
//        return product;
        try {
            if(id<=0) throw new IllegalArgumentException("invalid id");
            Product product=iFakeStoreProductService.getProductById(id);
            ProductDto response= getProductDto(product);
            MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
            headers.add("called by","Yashwant");
            return new ResponseEntity<>(response,headers, HttpStatus.OK);
        }
        catch (IllegalArgumentException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    private ProductDto getProductDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setName(product.getCategory().getName());
        productDto.setCategory(categoryDto);
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }
    @PostMapping
    public Product createProduct(ProductDto product){
        return null;
    }
}
