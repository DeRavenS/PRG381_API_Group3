package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.DStudent;
import com.springboot.App.DataAccessLayer.interfaces.DStudentsRepo;

@Service
@Transactional
public class DStudentsService {
    
    @Autowired
    private DStudentsRepo repo;

    public List<DStudent> listAll(){
        return repo.findAll();
    }

    public void save(DStudent students){
        //get auto id
        repo.save(students);
    }

    public DStudent getByID(String id){
        return repo.getReferenceById(id);
    }

    public DStudent getByEmail(String stud_email)
    {
        return repo.getStudentByEmail(stud_email);
    }

    public void delete(String student_id){
        repo.deleteById(student_id);
    }

    public DStudent get(String studentID) {
        return null;
    }
}
