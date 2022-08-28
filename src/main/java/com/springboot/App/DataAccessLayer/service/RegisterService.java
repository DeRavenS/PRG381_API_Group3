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

    public Register1 get(Integer id){
        return repo.findById(id).get();
    }

    public List<String> getStudentCourse(String id){
        return repo.findByStudentID(id);
    }

    public void deleteCourses(List<String> name,String id){
        repo.deleteCourses(name,id);
    }

    public void updateCourses(List<String> name, String id){
        for (String course : name) {
            repo.updateCourses(course,id);
        }
    }

    public void delete(Integer register_id){
        repo.deleteById(register_id);
    }

    public void deleteByStudentID(Integer student_id){
        repo.deleteByStudentId(student_id,student_id);
    }
}
