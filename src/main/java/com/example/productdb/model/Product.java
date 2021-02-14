package com.example.productdb.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private String color;
    private double price;
    private String dateOfManufacture;
    private String expirationDate;

    public static int productNumber = 0;

    public Product(String name, String color, double price, String dateOfManufacture, String expirationDate) {
        this();
        this.name = name;
        this.color = color;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
    }

    public Product(){
        id = ++productNumber;
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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", dateOfManufacture=" + dateOfManufacture +
                ", expirationDate=" + expirationDate +
                '}';
    }

}
