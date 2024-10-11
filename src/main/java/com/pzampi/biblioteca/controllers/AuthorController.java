package com.pzampi.biblioteca.controllers;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pzampi.biblioteca.models.Author;
import com.pzampi.biblioteca.services.AuthorService;

@Controller
public class AuthorController implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String listAll(Model model){
        List<Author> list = authorService.findAll();
        model.addAttribute("authors", list);
        return "authors";
    }
}
