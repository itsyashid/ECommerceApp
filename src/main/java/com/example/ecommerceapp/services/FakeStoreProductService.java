package com.example.ecommerceapp.services;

import com.example.ecommerceapp.dtos.FakeStoreProductDto;
import com.example.ecommerceapp.models.Product;
import com.example.ecommerceapp.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IFakeStoreProductService {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Override
    public List<Product> getAllProduct(){
        return null;
    }
    @Override
    public Product getProductById(Long id){
        RestTemplate restTemplate=restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,id).getBody();
        return  getProduct(fakeStoreProductDto);
    }
    private Product getProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        return product;
    }
    @Override
    public Product createProduct(Product product){
        return product;
    }
}
