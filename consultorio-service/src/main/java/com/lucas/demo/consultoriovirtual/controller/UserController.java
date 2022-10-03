package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping (value="/", method= RequestMethod.GET)
    public @ResponseBody List<User> findAll(){
        return userService.findAll();
    }
}

