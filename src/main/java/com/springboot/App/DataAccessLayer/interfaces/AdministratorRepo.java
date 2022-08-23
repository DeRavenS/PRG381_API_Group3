package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.App.DataAccessLayer.models.Administrator;

public interface AdministratorRepo extends JpaRepository<Administrator, Integer>{
    
}