package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.AdministratorRepo;
import com.springboot.App.DataAccessLayer.models.Administrator;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepo repo;

    public List<Administrator> listAll(){
        return repo.findAll();
    }

    public void save(Administrator administrator){
        repo.save(administrator);
    }

    public Administrator get(Integer admin_id){
        return repo.findById(admin_id).get();
    }

    public void delete(Integer admin_id){
        repo.deleteById(admin_id);
    }
}
