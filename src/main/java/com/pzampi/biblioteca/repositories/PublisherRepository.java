package com.pzampi.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.biblioteca.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
