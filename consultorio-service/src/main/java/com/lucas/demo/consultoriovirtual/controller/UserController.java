package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping (value="/", method= RequestMethod.GET)
    public @ResponseBody List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping (value="/", method= RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping (value="/login", method= RequestMethod.POST)
    public @ResponseBody User login(@RequestBody User user){
        return userService.login(user);
    }
}

