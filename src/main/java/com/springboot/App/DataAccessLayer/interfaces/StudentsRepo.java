package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.App.DataAccessLayer.models.Student;

public interface StudentsRepo extends JpaRepository<Student, Integer>{
    
}
