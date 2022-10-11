package com.lucas.demo.consultoriovirtual.service;

import com.lucas.demo.consultoriovirtual.model.Appointment;
import com.lucas.demo.consultoriovirtual.model.Company;
import com.lucas.demo.consultoriovirtual.model.Procedure;
import com.lucas.demo.consultoriovirtual.model.enums.AppointmentStatus;
import com.lucas.demo.consultoriovirtual.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository repository;

    public List<Appointment> findAll(){
        return (List<Appointment>) repository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        return repository.save(appointment);
    }

    public List<Appointment> findByEmployeeId(long id) {
        return repository.findByEmployeeId(id);
    }

    public List<Appointment> findByCustomerId(long id) {
        return repository.findByCustomerId(id);
    }
}
