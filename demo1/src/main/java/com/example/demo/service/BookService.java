package com.example.demo.service;



import com.example.demo.model.BookModel;

import java.util.List;


public interface BookService  {
    public List<BookModel> findAllBooks();
    public BookModel findBookById(int id);
    public BookModel addBook(BookModel goodsModel);
    public BookModel updateBook(BookModel goodsModel);
    public void deleteBook(int id);
    public void logicDeleteBook(int id);
    public void restoreAllDeletedBooks();

    public void deleteBooks(List<Integer> ids);
    public void logicDeleteBooks(List<Integer> ids);
    public List<BookModel> searchBooksByName(String name);
    public List<BookModel> filterBooks(int filterType);


}
