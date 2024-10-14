package com.pzampi.biblioteca.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.biblioteca.models.Author;
import com.pzampi.biblioteca.models.Publisher;
import com.pzampi.biblioteca.repositories.PublisherRepository;

@Service
public class PublisherService implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private PublisherRepository publisherRepositoy;

    public List<Publisher> findAll(){
        List<Publisher> list = publisherRepositoy.findAll();
        return list;
    }
    public Publisher findById(Long id){
        Optional<Publisher> obj = publisherRepositoy.findById(id);
        return obj.get();
    }


    public Publisher insert(Publisher obj){
        obj = publisherRepositoy.save(obj);
        return obj;
    }
}
