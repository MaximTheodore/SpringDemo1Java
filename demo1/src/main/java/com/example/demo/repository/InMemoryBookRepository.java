package com.example.demo.repository;


import com.example.demo.model.BookModel;
import com.example.demo.model.GoodsModel;
import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryBookRepository  {

    private final List<BookModel> BOOKS = new ArrayList<>();

    private AtomicInteger idCounter = new AtomicInteger(1);

    public BookModel addBook(BookModel bookModel){
        bookModel.setID(idCounter.getAndIncrement());
        BOOKS.add(bookModel);
        return bookModel;
    }
    public BookModel updateBook(BookModel bookModel){
        int bookIndex = IntStream.range(0, BOOKS.size())
                .filter(index -> BOOKS.get(index).getID() == bookModel.getID())
                .findFirst()
                .orElse(-1);

        return bookIndex == -1 ? null : BOOKS.set(bookIndex, bookModel);
    }

    public List<BookModel> findAllBooks() {
        return BOOKS.stream()
                .filter(bookModel -> !bookModel.isDeleted())
                .collect(Collectors.toList());
    }
    public BookModel findBookById(int id){
        return BOOKS.stream()
                .filter(bookModel -> bookModel.getID() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteBook(int id){
        var bookModel = findBookById(id);
        if (bookModel != null) {
            BOOKS.remove(bookModel);
        }
    }
    public void logicDeleteBook(int id){
        var bookModel = findBookById(id);
        if (bookModel != null) {
            bookModel.setDeleted(true);
        }
    }

    public void restoreAllDeletedBooks(){
        BOOKS.stream()
                .filter(BookModel::isDeleted)
                .forEach(bookModel -> bookModel.setDeleted(false));
    }
    public void deleteBooks(List<Integer> ids) {
        BOOKS.removeIf(bookModel -> ids.contains(bookModel.getID()));
    }

    //множественное логич удаление
    public void logicDeleteBooks(List<Integer> ids) {
        BOOKS.stream()
                .filter(bookModel -> ids.contains(bookModel.getID()))
                .forEach(bookModel -> bookModel.setDeleted(true));
    }

    public List<BookModel> searchBooksByName(String name) {
        return BOOKS.stream()
                .filter(bookModel -> !bookModel.isDeleted() && bookModel.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<BookModel> filterBooks(int filterType) {
        return BOOKS.stream()
                .filter(bookModel -> !bookModel.isDeleted())
                .filter(bookModel -> {
                    if (filterType == 1) {
                        return bookModel.getYear() >= 2010;
                    } else if (filterType == 2) {
                        return bookModel.getName().startsWith("А") || bookModel.getName().startsWith("A");
                    } else if (filterType == 3) {
                        return bookModel.getAuthor().startsWith("B") || bookModel.getAuthor().startsWith("Б");
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }



}
