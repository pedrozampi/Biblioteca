package com.pzampi.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.biblioteca.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
