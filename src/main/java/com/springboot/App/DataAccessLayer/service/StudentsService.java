package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.StudentsRepo;
import com.springboot.App.DataAccessLayer.models.Student;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepo repo;

    public List<Student> listAll(){
        return repo.findAll();
    }

    public void save(Student students){
        repo.save(students);
    }

    public Student get(Integer student_id){
        return repo.findById(student_id).get();
    }

    public void delete(Integer student_id){
        repo.deleteById(student_id);
    }
}
