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

import com.pzampi.biblioteca.models.Publisher;
import com.pzampi.biblioteca.services.PublisherService;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/adm/registerPublisher")
    public String registerPublisher(Model model){
        model.addAttribute("obj", new Publisher());
        return "register/registerPublisher";
    }

    @PostMapping(path = "/adm/registerPublisher")
    public String insert(@ModelAttribute Publisher Publisher, Model model){
        System.out.println(Publisher.toString());
        publisherService.insert(Publisher);
        model.addAttribute("obj", new Publisher());
        // return ResponseEntity.ok().body(obj.toString());
        return "redirect:/";
    }

    @GetMapping("/publishers")
    public String listPublishers(Model model){
        Iterable<Publisher> publishers = publisherService.findAll();
        model.addAttribute("publishers", publishers);
        return "publisher/publishers";
    }

    @GetMapping("/publisher/{id}")
    public String getPublisher(Model model, @PathVariable Long id){
        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publisher", publisher);
        return "publisher/publisher";
    }

}
