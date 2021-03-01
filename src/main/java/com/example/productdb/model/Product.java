package com.example.productdb.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String color;
    private double price;
    private String date_of_manufacture;
    private String expiration_date;


    public Product(String name, String color, double price, String date_of_manufacture, String expiration_date) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.date_of_manufacture = date_of_manufacture;
        this.expiration_date = expiration_date;
    }

    public Product(){
    }

    public int getId() {
        return id;
    }

    public String getDate_of_manufacture() {
        return date_of_manufacture;
    }

    public void setDate_of_manufacture(String date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
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
                ", \"date_of_manufacture\":\"" + date_of_manufacture + '\"' +
                ", \"expiration_date\":\"" + expiration_date + "\"" +
                '}';
    }

}
