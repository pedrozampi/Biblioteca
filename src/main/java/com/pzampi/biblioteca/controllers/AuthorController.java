package com.pzampi.biblioteca.controllers;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pzampi.biblioteca.models.Author;
import com.pzampi.biblioteca.models.Book;
import com.pzampi.biblioteca.services.AuthorService;

@Controller
public class AuthorController implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String listAll(Model model){
        Iterable<Author> autrs = authorService.findAll();
        model.addAttribute("authors", autrs);
        return "author/authors";
    }

    @GetMapping("/author/{id}")
    public String findById(Model model, @PathVariable Long id){
        Author obj = authorService.findById(id);
        model.addAttribute("author", obj);
        return "author/author";
    }
}
