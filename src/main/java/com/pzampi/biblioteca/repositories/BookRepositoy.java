package com.pzampi.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.biblioteca.models.Book;

public interface BookRepositoy extends JpaRepository<Book, Long> {

}
