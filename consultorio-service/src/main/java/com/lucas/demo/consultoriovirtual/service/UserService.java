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


    public User createUpdateUser(User user){
        return repository.save(user);
    }

    public User login(User user){
        List<User> usersInDatabase = repository.findByUsername(user.getUsername());
        if(usersInDatabase.size()<=0){
            return null;
        }else{
            User userInDataBase = usersInDatabase.get(0);
            if(user.getUsername().equals(userInDataBase.getUsername()) && user.getPassword().equals(userInDataBase.getPassword())){
                return userInDataBase;
            }else{
                return null;
            }
        }
    }

    public List<User> deleteUser(long id) {
        User user = repository.findById(id);
        repository.delete(user);
        return findAll();
    }

    public User findById(long userID) {
        return repository.findById(userID);
    }
}
