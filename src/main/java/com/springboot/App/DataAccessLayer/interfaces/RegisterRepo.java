package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
// import com.springboot.App.DataAccessLayer.models.Register;
import com.springboot.App.DataAccessLayer.models.Register1;

@Repository
public interface RegisterRepo extends JpaRepository<Register1, Integer>{
    
}
