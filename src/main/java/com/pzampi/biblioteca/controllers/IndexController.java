package com.pzampi.biblioteca.controllers;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.spring6.view.ThymeleafView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() { 
        return "index";
    }

    @Bean(name = "content-part")
    @Scope("prototype")
    public ThymeleafView someViewBean(){
        ThymeleafView view = new ThymeleafView("test");
        view.setMarkupSelector("content");
        return view;
    }

    @GetMapping("/showContentPart")
    public String showContentPart(final Locale locale) {
        
        return "content-part";
    }
}
