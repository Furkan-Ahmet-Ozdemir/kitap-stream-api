package org.example.model;

import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private BigDecimal amount;
    private String descripton;

    public Product(String name, BigDecimal amount, String descripton) {
        this.name = name;
        this.amount = amount;
        this.descripton = descripton;
    }


    public Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", descripton='" + descripton + '\'' +
                '}';
    }


}
