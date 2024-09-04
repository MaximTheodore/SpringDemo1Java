package com.example.demo.controller;


import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController  {

    @Autowired
    private BookService bookService;


    @GetMapping("/book")
    public String getAllBooks(Model model) {
        model.addAttribute("book", bookService.findAllBooks());
        return "BookList";
    }

    @PostMapping("/book/add")
    public String addBook(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String author,
            @RequestParam int year,
            @RequestParam(defaultValue = "false") boolean isDeleted) {
        BookModel newBook = new BookModel(0, name,description, author, year, isDeleted);
        bookService.addBook(newBook);
        return "redirect:/book";
    }

    @PostMapping("/book/update")
    public String updateBook(@RequestParam int id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam String author,
                              @RequestParam int year,
                             @RequestParam(defaultValue = "false") boolean isDeleted) {
        BookModel newBook = new BookModel(id, name,description, author, year, isDeleted);
        bookService.updateBook(newBook);
        return "redirect:/book";
    }

    @PostMapping("/book/delete")
    public String deleteBook(@RequestParam int id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }
    private List<Integer> idents = new ArrayList<>();
    @PostMapping("/book/logic_delete")
    public String logicDeleteBook(@RequestParam int id) {
        idents.add(id);
        bookService.logicDeleteBook(id);
        return "redirect:/book";
    }

    @PostMapping("/book/deletes")
    public String deleteBooks(){
        bookService.deleteBooks(idents);
        return "redirect:/book";
    }

    @PostMapping("/book/logic_deletes")
    public String logicDeleteBooks(@RequestParam("ids") List<Integer> ids){

        bookService.logicDeleteBooks(ids);
        return "redirect:/book";
    }

    @PostMapping("/book/search")
    public String searchBooksByName(Model model,@RequestParam String name){
        model.addAttribute("book", bookService.searchBooksByName(name));
        return "BookList";
    }

    @PostMapping("/book/filter")
    public String filterBooks(Model model, @RequestParam int filterType){
        model.addAttribute("book", bookService.filterBooks(filterType));
        return "BookList";
    }

    @PostMapping("/book/restore")
    public String restoreAllDeletedBooks(){
        bookService.restoreAllDeletedBooks();
        return "redirect:/book";
    }
}
