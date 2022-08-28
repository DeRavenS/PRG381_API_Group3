package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

// import com.springboot.App.DataAccessLayer.interfaces.AdministratorRepo;
import com.springboot.App.DataAccessLayer.interfaces.DAdmin;
// import com.springboot.App.DataAccessLayer.models.Admin;
// import com.springboot.App.DataAccessLayer.models.Admin;
// import com.springboot.App.DataAccessLayer.models.Administrator;
import com.springboot.App.DataAccessLayer.interfaces.DAdministratorRepo;

@Service
@Transactional
public class DAdministratorService {

    @Autowired
    DAdministratorRepo aRepo;

    public List<DAdmin> getAll()
    {
        return aRepo.findAll();
    }

  

    public List<DAdmin> listAll(){
        return aRepo.findAll();
    }

    public void save(DAdmin administrator){
        aRepo.save(administrator);
    }

    public DAdmin get(String adminID){
        return aRepo.findById(adminID).get();
    }

    public void delete(String admin_id){
        aRepo.deleteById(admin_id);
    }
}
