package com.pzampi.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.View;

import com.pzampi.biblioteca.models.Book;
import com.pzampi.biblioteca.services.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/adm/registerbook")
    public String registerBook(Model model){
        model.addAttribute("obj", new Book());
        return "register/registerbook";
    }

    @PostMapping(path = "/adm/registerbook")
    public String insert(@ModelAttribute Book book, Model model){
        System.out.println(book.toString());
        bookService.insert(book);
        model.addAttribute("obj", new Book());
        // return ResponseEntity.ok().body(obj.toString());
        return "redirect:/";
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/books";
    }

    @GetMapping("/book/{id}")
    public String getBook(Model model, @PathVariable Long id){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/book";
    }

}
