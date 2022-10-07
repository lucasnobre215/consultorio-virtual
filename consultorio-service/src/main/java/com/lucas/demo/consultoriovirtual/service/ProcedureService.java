package com.lucas.demo.consultoriovirtual.service;

import com.lucas.demo.consultoriovirtual.model.Procedure;
import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.repository.CompanyRepository;
import com.lucas.demo.consultoriovirtual.repository.ProccedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureService {

    @Autowired
    ProccedureRepository repository;

    public List<Procedure> findAll(){
        return (List<Procedure>) repository.findAll();
    }

    public Procedure createUpdateProcedure(Procedure procedure) {
        return repository.save(procedure);
    }

    public List<Procedure> deleteProcedure(long id) {
        Procedure procedure = repository.findById(id);
        repository.delete(procedure);
        return findAll();
    }

    public Procedure findById(int id) {
        return repository.findById(id);
    }

    public List<Procedure> findByCompanyId(int id) {
        return repository.findByCompanyId(id);
    }
}
