package com.lucas.demo.consultoriovirtual.service;

import com.lucas.demo.consultoriovirtual.model.Company;
import com.lucas.demo.consultoriovirtual.model.User;
import com.lucas.demo.consultoriovirtual.repository.CompanyRepository;
import com.lucas.demo.consultoriovirtual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public List<Company> findAll(){
        return (List<Company>) repository.findAll();
    }

    public Company createUpdateCompany(Company company){
        return repository.save(company);
    }
    public List<Company> deleteCompany(long id) {
        Company user = repository.findById(id);
        repository.delete(user);
        return findAll();
    }

    public Company findById(long userID) {
        return repository.findById(userID);
    }
}
