package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.App.DataAccessLayer.models.Administrator;

// import com.springboot.App.DataAccessLayer.models.Administrator;

@Repository
public interface AdministratorRepo extends JpaRepository<Administrator, Integer>{
    
}
