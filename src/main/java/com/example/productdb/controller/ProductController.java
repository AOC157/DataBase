package com.example.productdb.controller;

import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    public ProductRepository productRepository;


    @RequestMapping(value = "/" , method = RequestMethod.POST , consumes = "application/json")
    public String productPostRequest(Product product){
        productRepository.save(product);

        return product.toString();
    }

    @GetMapping(value = "/" ,produces = "application/json")
    public HttpEntity<Product> productGetRequest(){
        Product product = new Product("pen" , "red" , 5000.0 , "1399.09.30" , "");

        return new HttpEntity<>(product);
    }
}
