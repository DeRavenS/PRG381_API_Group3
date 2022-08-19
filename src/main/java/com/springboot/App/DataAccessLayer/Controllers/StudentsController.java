package com.springboot.App.DataAccessLayer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.App.DataAccessLayer.service.StudentsService;

import com.springboot.App.DataAccessLayer.models.Student;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentsController {
    
    @Autowired
    private StudentsService service;

    @GetMapping("/student")
    public List<Student> listStudent(){
        return service.listAll();
    }
}
