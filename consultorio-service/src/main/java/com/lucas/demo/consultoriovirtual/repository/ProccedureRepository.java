package com.lucas.demo.consultoriovirtual.repository;

import com.lucas.demo.consultoriovirtual.model.Appointment;
import com.lucas.demo.consultoriovirtual.model.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ProccedureRepository extends CrudRepository<Procedure, Long> {

    Procedure findById(long id);

    List<Procedure> findByCompanyId(long id);

}
