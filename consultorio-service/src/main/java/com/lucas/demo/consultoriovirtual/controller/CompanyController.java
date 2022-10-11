package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.Company;
import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.model.enums.UserRoles;
import com.lucas.demo.consultoriovirtual.service.CompanyService;
import com.lucas.demo.consultoriovirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService service;


    @RequestMapping (value="/", method= RequestMethod.GET)
    public @ResponseBody List<Company> findAll(){
        return service.findAll();
    }

    @RequestMapping (value="/", method= RequestMethod.POST)
    public @ResponseBody Company createCompany(@RequestBody Company company){
        return service.createUpdateCompany(company);
    }
    @RequestMapping (value="/{id}", method= RequestMethod.DELETE)
    public @ResponseBody List<Company> deleteCompany(@PathVariable long id){
        return service.deleteCompany(id);
    }

    @RequestMapping (value="/{id}", method= RequestMethod.GET)
    public @ResponseBody Company findById(@PathVariable int id){
        return service.findById(id);
    }
}

