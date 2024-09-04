package com.example.demo.entity;

import com.example.demo.model.BookModel;

public class BookEntity extends BookModel {
    public BookEntity(int id, String name, String description, String author, int year, boolean isDeleted) {
        super(id, name, description, author, year, isDeleted);
    }
}
