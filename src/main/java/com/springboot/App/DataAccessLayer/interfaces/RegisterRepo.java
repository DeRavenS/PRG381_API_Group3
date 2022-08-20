package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.App.DataAccessLayer.models.Register;

public interface RegisterRepo extends JpaRepository<Register, Integer>{
    
}
