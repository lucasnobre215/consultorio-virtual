package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.Procedure;
import com.lucas.demo.consultoriovirtual.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/procedure")
public class ProcedureController {

    @Autowired
    ProcedureService service;


    @RequestMapping (value="/", method= RequestMethod.GET)
    public @ResponseBody List<Procedure> findAll(){
        return service.findAll();
    }

    @RequestMapping (value="/", method= RequestMethod.POST)
    public @ResponseBody Procedure createProcedure(@RequestBody Procedure procedure){
        return service.createUpdateProcedure(procedure);
    }

    @RequestMapping (value="/{id}", method= RequestMethod.DELETE)
    public @ResponseBody List<Procedure> deleteProcedure(@PathVariable long id){
        return service.deleteProcedure(id);
    }

    @RequestMapping (value="/company/{id}", method= RequestMethod.GET)
    public @ResponseBody List<Procedure> findByCompanyId(@PathVariable int id){
        return service.findByCompanyId(id);
    }

    @RequestMapping (value="/{id}", method= RequestMethod.GET)
    public @ResponseBody Procedure findById(@PathVariable int id){
        return service.findById(id);
    }


}

