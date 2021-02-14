package com.example.productdb.service;

import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        saveProduct();
        //loadProduct();
    }

    public void saveProduct(){
        Product product1 = new Product("oil" , "yellow" , 40000.0, "1399.11.10" , "1400.03.10");
        Product product2 = new Product("cheese" , "blue" , 10000.0, "1399.11.00" , "1400.01.01");
        Product product3 = new Product("cheese" , "blue" , 20000.0, "1399.11.00" , "1400.01.01");
        Product product4 = new Product("shoes" , "black" , 300000.0 , "1399.7.1" , "");

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
    }

    public void loadProduct(){
        List<Product> allProducts = productRepository.findAll();

        for(Product p : allProducts){
            System.out.println(p);
        }
    }

}
