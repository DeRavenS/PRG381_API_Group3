package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.AdministratorRepo;
import com.springboot.App.DataAccessLayer.models.Administrator;

@Service
@Transactional
public class AdministratorService {

    @Autowired
    AdministratorRepo aRepo;

    public List<Administrator> getAll()
    {
        return aRepo.findAll();
    }

    public List<Administrator> listAll(){
        return aRepo.findAll();
    }

    public void save(Administrator administrator){
        aRepo.save(administrator);
    }

    public Administrator get(Integer ID){
        return aRepo.findById(ID).get();
    }

    public void delete(Integer admin_id){
        aRepo.deleteById(admin_id);
    }

    public Administrator findByEmail(String email) {
        return aRepo.getAdminByEmail(email);
    }
}
