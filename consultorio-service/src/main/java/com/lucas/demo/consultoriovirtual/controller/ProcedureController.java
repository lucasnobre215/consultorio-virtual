package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.Procedure;
import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.service.ProcedureService;
import com.lucas.demo.consultoriovirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proccedure")
public class ProccedureController {

    @Autowired
    ProcedureService service;


    @RequestMapping (value="/", method= RequestMethod.GET)
    public @ResponseBody List<Procedure> findAll(){
        return service.findAll();
    }

    @RequestMapping (value="/", method= RequestMethod.POST)
    public @ResponseBody Procedure createUser(@RequestBody Procedure user){
        return service.createUpdateProccedure(user);
    }
    @RequestMapping (value="/{id}", method= RequestMethod.DELETE)
    public @ResponseBody List<Procedure> deleteUser(@PathVariable long id){
        return service.deleteProccedure(id);
    }

    @RequestMapping (value="/{id}", method= RequestMethod.GET)
    public @ResponseBody Procedure findById(@PathVariable int id){
        return service.findById(id);
    }

}

