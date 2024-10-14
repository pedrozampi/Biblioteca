package com.pzampi.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pzampi.biblioteca.models.Book;
import com.pzampi.biblioteca.models.User;
import com.pzampi.biblioteca.services.UserService;

@Controller
public class UserController{

    private UserService userService;

    @GetMapping("/signin")
    public String signIn(Model model){
        model.addAttribute("usr", new User());
        return "signin";
    }

    @PostMapping(path = "/signin")
    public String insert(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        model.addAttribute("usr", new User());
        // return ResponseEntity.ok().body(obj.toString());
        return "redirect:/";
    }
}
