package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.App.DataAccessLayer.models.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>{
    
}
