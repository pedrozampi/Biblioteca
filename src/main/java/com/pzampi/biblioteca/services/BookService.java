package com.pzampi.biblioteca.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.biblioteca.models.Book;
import com.pzampi.biblioteca.repositories.BookRepositoy;

@Service
public class BookService implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private BookRepositoy bookRepositoy;

    public List<Book> findAll(){
        List<Book> list = bookRepositoy.findAll();
        return list;
    }

    public Book insert(Book obj){
        obj = bookRepositoy.save(obj);
        return obj;
    }
}
