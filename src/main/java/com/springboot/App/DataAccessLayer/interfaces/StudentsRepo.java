package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<DStudent, String>{
    
}
