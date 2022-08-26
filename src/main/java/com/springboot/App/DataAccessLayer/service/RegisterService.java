package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.RegisterRepo;
import com.springboot.App.DataAccessLayer.models.Register;

@Service
public class RegisterService {
    
    @Autowired
    private RegisterRepo repo;

    public List<Register> listAll(){
        return repo.findAll();
    }

    public void save(Register register){
        repo.save(register);
    }

    public Register get(Integer register_id){
        return repo.findById(register_id).get();
    }

    public void delete(Integer register_id){
        repo.deleteById(register_id);
    }
}
