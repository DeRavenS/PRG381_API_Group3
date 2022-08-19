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

import com.springboot.App.DataAccessLayer.service.AdministratorService;

import com.springboot.App.DataAccessLayer.models.Administrator;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AdministratorController {
    
    @Autowired
    private AdministratorService service;

    @GetMapping("/admin")
    public List<Administrator> listAdmin(){
        return service.listAll();
    }

    @GetMapping("/admin/{admin_id}")
    public ResponseEntity<Administrator> getAdmin(@PathVariable Integer admin_id){
        try {
            Administrator admin = service.get(admin_id);
            return new ResponseEntity<Administrator>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin")
    public void addAdmin(@RequestBody Administrator admin){
        service.save(admin);
    }

    @PutMapping("/admin/{admin_id}")
    public ResponseEntity<Administrator> updateAdmin(@RequestBody Administrator admin, @PathVariable Integer admin_id){
        try {
            Administrator existAdmin = service.get(admin_id);
            service.save(admin);
            return new ResponseEntity<Administrator>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/{admin_id}")
    public ResponseEntity<Administrator> deleteAdmin(@PathVariable Integer admin_id){
        try {
            service.delete(admin_id);
            return new ResponseEntity<Administrator>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }
}
