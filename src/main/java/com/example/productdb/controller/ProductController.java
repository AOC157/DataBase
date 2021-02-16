package com.example.productdb.controller;

import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public void saveProduct(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            Product product = new Product();

            System.out.print("enter name: ");
            product.setName(scanner.nextLine());

            System.out.print("enter color: ");
            product.setColor(scanner.nextLine());

            System.out.print("enter price: ");
            product.setPrice(Double.parseDouble(scanner.nextLine()));

            System.out.print("enter date of manufacture: ");
            product.setDateOfManufacture(scanner.nextLine());

            System.out.print("enter expiration date: ");
            product.setExpirationDate(scanner.nextLine());

            productRepository.save(product);

            System.out.print("do you want to finish?(if yes press \"y\") ");
            if (scanner.nextLine().charAt(0) == 'y'){
                break;
            }

        }
    }


    @RequestMapping("/")
    public String showProduct(){
        saveProduct();

        List<Product> allProducts = productRepository.findAll();

        StringBuilder builder = new StringBuilder();

        for(Product p : allProducts){
            builder.append(p.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}
