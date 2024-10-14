package com.pzampi.biblioteca.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.biblioteca.models.User;
import com.pzampi.biblioteca.repositories.UserRepository;

@Service
public class UserService implements Serializable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserRepository userRepository;

    public User signIn(User usr){
        User login = userRepository.findByUser(usr.getUser()).get();
        if(usr.equals(login)) return login;
        else return null;
    }

}
