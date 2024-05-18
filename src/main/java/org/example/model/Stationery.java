package org.example.model;

import java.math.BigDecimal;

public class Stationery extends Product {

    private String brand;
    private String category;

    // TODO: 18.05.2024 Category modeli eklenecek


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Stationery(String name, BigDecimal amount, String descripton, String brand, String category) {
        super(name, amount, descripton);
        this.brand = brand;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
