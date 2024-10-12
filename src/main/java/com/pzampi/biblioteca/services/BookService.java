package com.pzampi.biblioteca.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.biblioteca.models.Book;
import com.pzampi.biblioteca.repositories.BookRepository;

@Service
public class BookService implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private BookRepository bookRepositoy;

    public List<Book> findAll(){
        List<Book> list = bookRepositoy.findAll();
        return list;
    }

    public Book findById(Long id){
        Optional<Book> obj = bookRepositoy.findById(id);
        return obj.get();
    }

    public Book insert(Book obj){
        obj = bookRepositoy.save(obj);
        return obj;
    }
}
