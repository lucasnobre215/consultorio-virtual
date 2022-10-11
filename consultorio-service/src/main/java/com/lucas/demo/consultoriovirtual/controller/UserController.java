package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.Company;
import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.model.enums.UserRoles;
import com.lucas.demo.consultoriovirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody User createUser(@RequestBody User user){
        return userService.createUpdateUser(user);
    }
    @RequestMapping (value="/{id}", method= RequestMethod.DELETE)
    public @ResponseBody List<User> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

    @RequestMapping (value="/{id}", method= RequestMethod.GET)
    public @ResponseBody User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @RequestMapping (value="/{id}/{role}", method= RequestMethod.GET)
    public @ResponseBody List<User> findUserByIdAndRole(@PathVariable long id, @PathVariable UserRoles role){
        return userService.findByCompanyIdAndUserRole(id, role);
    }

    @RequestMapping (value="/login", method= RequestMethod.POST)
    public @ResponseBody User login(@RequestBody User user){
        return userService.login(user);
    }
}

