package com.lucas.demo.consultoriovirtual.service;

import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return (List<User>) repository.findAll();
    }
}
