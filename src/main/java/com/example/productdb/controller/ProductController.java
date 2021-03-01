package com.example.productdb.controller;

import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductRepository productRepository;


    @PostMapping(value = "/insertProduct")
    public String insertProduct(@RequestBody Product product){
        productRepository.save(product);
        return product.toString();
    }

    @GetMapping(value = "/productList")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/oneProduct/{id}")
    public Product getOneProduct(@PathVariable("id") int id) {
        return productRepository.getOne(id);
    }

    @PutMapping(value = "/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        if(productRepository.existsById(product.getId())) {
            productRepository.save(product);
        }
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }
}
