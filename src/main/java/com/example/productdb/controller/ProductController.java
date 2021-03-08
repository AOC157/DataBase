package com.example.productdb.controller;

import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    @Autowired
    public ProductRepository productRepository;


    @PostMapping(value = "/insert")
    public Product insertProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping(value = "/getAll")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public String getOneProduct(@PathVariable("id") int id) {
        if(productRepository.existsById(id)) {
            return productRepository.getOne(id).toString();
        }
        throw new ObjectNotFoundException("doesn't exist" , Integer.toString(id));
    }

    @PutMapping(value = "/update")
    public Product updateProduct(@RequestBody Product product) {
        if(productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        throw new ObjectNotFoundException("doesn't exist" , Integer.toString(product.getId()));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        if (productRepository.existsById(id)) {
            String result = productRepository.getOne(id).toString();
            productRepository.deleteById(id);
            return result;
        }
        throw new ObjectNotFoundException("doesn't exist" , Integer.toString(id));
    }
}
