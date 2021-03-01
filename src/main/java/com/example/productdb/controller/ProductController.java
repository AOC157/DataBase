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
        Product productFromDB = productRepository.getOne(product.getId());
        productFromDB.setName(product.getName());
        productFromDB.setColor(product.getColor());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setExpiration_date(product.getExpiration_date());
        productFromDB.setDate_of_manufacture(product.getDate_of_manufacture());
        productRepository.save(productFromDB);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }
}
