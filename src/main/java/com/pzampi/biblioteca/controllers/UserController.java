package com.pzampi.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String signIn(Model model){
        model.addAttribute("usr", new User());
        return "signin";
    }

    @PostMapping(path = "/signin")
    public String insert(@ModelAttribute User user, Model model){
        User Login = userService.signIn(user);
        if(Login != null){
            model.addAttribute("usr", Login);
            return "register/adm-menu";
        }
        model.addAttribute("err", "User not found");
        model.addAttribute("usr", new User());
        return "signin";
    }
}
