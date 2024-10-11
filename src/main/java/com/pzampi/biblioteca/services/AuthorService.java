package com.pzampi.biblioteca.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.biblioteca.models.Author;
import com.pzampi.biblioteca.repositories.AuthorRepository;

@Service
public class AuthorService implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private AuthorRepository AuthorRepositoy;

    public List<Author> findAll(){
        List<Author> list = AuthorRepositoy.findAll();
        return list;
    }

    public Author insert(Author obj){
        obj = AuthorRepositoy.save(obj);
        return obj;
    }
}
