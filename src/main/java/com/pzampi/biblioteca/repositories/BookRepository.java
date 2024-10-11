package com.pzampi.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.biblioteca.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
