package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {

    private String author;
    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}