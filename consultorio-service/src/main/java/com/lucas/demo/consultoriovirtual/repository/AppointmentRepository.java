package com.lucas.demo.consultoriovirtual.repository;

import com.lucas.demo.consultoriovirtual.model.Appointment;
import com.lucas.demo.consultoriovirtual.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    Appointment findById(long id);

}
