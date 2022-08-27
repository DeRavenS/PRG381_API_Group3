package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.StudentsRepo;
import com.springboot.App.DataAccessLayer.models.Student;

@Service
@Transactional
public class StudentsService {
    
    @Autowired
    private StudentsRepo repo;

    public List<Student> listAll(){
        return repo.findAll();
    }

    public void save(Student students){
        //get auto id
        repo.save(students);
    }

    public Student getByID(int student_id){
        return repo.getReferenceById(student_id);
    }

    public Student getByEmail(String stud_email)
    {
        return repo.getStudentByEmail(stud_email);
    }

    public void delete(int student_id){
        repo.deleteById(student_id);
    }
}
