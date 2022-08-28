package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.springboot.App.DataAccessLayer.interfaces.DStudent;
import com.springboot.App.DataAccessLayer.interfaces.StudentsRepo;
import com.springboot.App.DataAccessLayer.models.Student;

@Service
@Transactional
public class StudentsService {
    
    @Autowired
    private StudentsRepo repo;

    public List<Student> listAll(Integer page, Integer size){
        return repo.findAllPage(page, size);
    }

    public void save(Student students){
        //get auto id
        repo.save(students);
    }

    public Student getByID(String id){
        return repo.getReferenceById(Integer.parseInt(id));
    }

    public Student getByEmail(String stud_email){
        return repo.getStudentByEmail(stud_email);
    }

    public void delete(Integer student_id){
        repo.deleteById(student_id);
    }
}
