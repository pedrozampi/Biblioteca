package com.pzampi.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.biblioteca.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String usr);
}
