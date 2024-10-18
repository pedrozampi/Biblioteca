package com.pzampi.biblioteca.services;

import java.io.Serializable;
import java.util.Optional;

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
        Optional<User> login = userRepository.findByUserName(usr.getUserName());
        if(login.isEmpty()) return null;
        if(usr.getUserName().contentEquals(login.get().getUserName()) && usr.getPasswd().contentEquals(login.get().getPasswd())) return login.get();
        else return null;
    }

}
