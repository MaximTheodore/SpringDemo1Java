package com.example.demo.service;

import com.example.demo.model.BookModel;
import com.example.demo.repository.InMemoryBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryBookServiceImpl implements BookService{

    private final InMemoryBookRepository bookRepository;

    public  inMemoryBookServiceImpl(InMemoryBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookModel> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public BookModel findBookById(int id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public BookModel addBook(BookModel goodsModel) {
        return bookRepository.addBook(goodsModel);
    }

    @Override
    public BookModel updateBook(BookModel goodsModel) {
        return bookRepository.updateBook(goodsModel);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public void logicDeleteBook(int id) { bookRepository.logicDeleteBook(id);}

    @Override
    public void restoreAllDeletedBooks() { bookRepository.restoreAllDeletedBooks(); }

    @Override
    public void deleteBooks(List<Integer> ids) {
        bookRepository.deleteBooks(ids);
    }

    @Override
    public void logicDeleteBooks(List<Integer> ids) {
        bookRepository.logicDeleteBooks(ids);
    }

    @Override
    public List<BookModel> searchBooksByName(String name) {
        return bookRepository.searchBooksByName(name);
    }

    @Override
    public List<BookModel> filterBooks(int filterType) {
        return bookRepository.filterBooks(filterType);
    }

}
