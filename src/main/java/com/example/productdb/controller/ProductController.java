package com.example.productdb.controller;

import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }


    @RequestMapping(value = "/test/postmethod/saveProduct" , method = RequestMethod.POST , consumes = "application/json")
    public String showProduct(@RequestBody Product product){
        saveProduct(product);

        return product.toString();
    }
}
