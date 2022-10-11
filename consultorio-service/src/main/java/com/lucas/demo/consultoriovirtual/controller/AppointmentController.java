package com.lucas.demo.consultoriovirtual.controller;


import com.lucas.demo.consultoriovirtual.model.Appointment;
import com.lucas.demo.consultoriovirtual.model.Company;
import com.lucas.demo.consultoriovirtual.model.enums.UserRoles;
import com.lucas.demo.consultoriovirtual.service.AppointmentService;
import com.lucas.demo.consultoriovirtual.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService service;


    @RequestMapping (value="/", method= RequestMethod.GET)
    public @ResponseBody List<Appointment> findAll(){
        return service.findAll();
    }

    @RequestMapping (value="/", method= RequestMethod.POST)
    public @ResponseBody Appointment createCompany(@RequestBody Appointment appointment){
        return service.createAppointment(appointment);
    }

    @RequestMapping (value="/{role}/{id}", method= RequestMethod.GET)
    public @ResponseBody List<Appointment> findByUserId(@PathVariable long id,@PathVariable UserRoles role ){
        if(role.equals(UserRoles.CUSTOMER)){
            return service.findByCustomerId(id);
        }else{
            return service.findByEmployeeId(id);
        }
    }
}

