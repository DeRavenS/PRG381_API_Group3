package com.springboot.App.DataAccessLayer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.App.DataAccessLayer.interfaces.RegisterRepo;
import com.springboot.App.DataAccessLayer.models.Register1;

@Service
@Transactional
public class RegisterService {
    
    @Autowired
    private RegisterRepo repo;

    public List<Register1> listAll(){
        return repo.findAll();
    }

    public void save(Register1 register){
        repo.save(register);
    }

    public Register1 get(String id){
        return repo.findById(id).get();
    }

    public List<String> getStudentCourse(String id){
        return repo.findByStudentID(id);
    }

    public void deleteCourses(List<String> name){
        repo.deleteCourses(name);
    }

    public void updateCourses(List<String> name, String id){
        String query = "";
        for (String course : name) {
            query += ",(" + id + ", " + course + ")";
        }
        query = query.substring(1, query.length() - 1);
        repo.updateCourses(query);
    }

    public void delete(String register_id){
        repo.deleteById(register_id);
    }
}
