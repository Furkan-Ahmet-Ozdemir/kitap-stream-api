package org.example.model;

import java.math.BigDecimal;

public class Book extends Product{
    // TODO: 18.05.2024 Author modeli eklenecek
    private String author;
    private Integer page;

    public Book(String author, Integer page){
        super("Çalıkuşu", new BigDecimal(10), "Açıklama");
        this.author = author;
        this.page = page;
    }

    public Book(String name, BigDecimal amount, String descripton, String author, Integer page) {
        super(name, amount, descripton);
        this.author = author;
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", page=" + page +
                '}';
    }
}
