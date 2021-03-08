package com.example.productdb.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @NotNull(message = "name can't be null")
    @Size(min = 1, max = 200)
    private String name;
    @NotNull(message = "color cannot be null")
    @Size(min = 1, max = 200)
    private String color;
    @NotNull(message = "price cannot be null")
    @Min(value = 1)
    private double price;
    @NotNull(message = "date of manufacture cannot be null")
    @Size(min = 5, max = 200)
    private String dateOfManufacture;
    private String expirationDate;


    public Product(String name, String color, double price, String dateOfManufacture, String expirationDate) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
    }

    public Product(){
    }

    public int getId() {
        return id;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"color\":\"" + color + '\"' +
                ", \"price\":" + price +
                ", \"dateOfManufacture\":\"" + dateOfManufacture + '\"' +
                ", \"expirationDate\":\"" + expirationDate + "\"" +
                '}';
    }

}
