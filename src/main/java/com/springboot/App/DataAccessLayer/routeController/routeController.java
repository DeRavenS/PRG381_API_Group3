package com.springboot.App.DataAccessLayer.routeController;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.springboot.App.DataAccessLayer.models.Administrator;
import com.springboot.App.DataAccessLayer.models.BrowsedStudent;
import com.springboot.App.DataAccessLayer.models.Register;
import com.springboot.App.DataAccessLayer.models.Student;
import com.springboot.App.DataAccessLayer.service.AdministratorService;
import com.springboot.App.DataAccessLayer.service.RegisterService;
import com.springboot.App.DataAccessLayer.service.StudentsService;

@RestController
public class routeController {
   
    @Autowired
    private AdministratorService AdminService;

    @Autowired
    private StudentsService StudentService;

    @Autowired
    private RegisterService RegisterService;

    /*
     * Routes to INSERT/UPDATE/DELETE/SELECT the Administartor table in MySQL
     */

    @GetMapping("/api/admin")
    public List<Administrator> listAdmin(){
        return AdminService.listAll();
    }

    @GetMapping("/api/admin/{admin_id}")
    public ResponseEntity<Administrator> getAdmin(@PathVariable Integer admin_id){
        try {
            Administrator admin = AdminService.get(admin_id);
            return new ResponseEntity<Administrator>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/admin")
    public void addAdmin(@RequestBody Administrator admin){
        AdminService.save(admin);
    }

    @PutMapping("/api/admin/{admin_id}")
    public ResponseEntity<Administrator> updateAdmin(@RequestBody Administrator admin, @PathVariable Integer admin_id){
        try {
            Administrator existAdmin = AdminService.get(admin_id);
            AdminService.save(admin);
            return new ResponseEntity<Administrator>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/admin/{admin_id}")
    public ResponseEntity<Administrator> deleteAdmin(@PathVariable Integer admin_id){
        try {
            AdminService.delete(admin_id);
            return new ResponseEntity<Administrator>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Routes to INSERT/UPDATE/DELETE/SELECT the Student table in MySQL
     */

    @PostMapping("/api/student")
    public pagedResponse<BrowsedStudent> listStudent(){
        pagedResponse<BrowsedStudent> response = new pagedResponse<BrowsedStudent>(); 
        for (Student student  : StudentService.listAll()) {
            response.items.add(new BrowsedStudent(Integer.toString(student.getStudent_id()),student.getStudent_name(),student.getStudent_address(),student.getStudent_email()));
        }
        response.totalItems=response.items.size();
        response.itemsPerPage=10;
        return response;
    }

    @GetMapping("/api/student/{student_id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer student_id){
        try {
            Student student = StudentService.get(student_id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

   /*  @PostMapping("/api/student")
    public void addStudent(@RequestBody Student student){
        StudentService.save(student);
    }*/

    @PutMapping("/api/student/{student_id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer student_id){
        try {
            Student existStudent = StudentService.get(student_id);
            StudentService.save(student);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/student/{student_id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer student_id){
        try {
            StudentService.delete(student_id);
            return new ResponseEntity<Student>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Routes to INSERT/UPDATE/DELETE/SELECT the Register table in MySQL
     */

    @GetMapping("/api/register")
    public List<Register> listRegister(){
        return RegisterService.listAll();
    }

    @GetMapping("/api/register/{register_id}")
    public ResponseEntity<Register> getRegister(@PathVariable Integer register_id){
        try {
            Register register = RegisterService.get(register_id);
            return new ResponseEntity<Register>(register, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/register")
    public void addStudent(@RequestBody Register register){
        RegisterService.save(register);
    }

    @PutMapping("/api/register/{register_id}")
    public ResponseEntity<Register> updateRegister(@RequestBody Register register, @PathVariable Integer register_id){
        try {
            Register existRegister = RegisterService.get(register_id);
            RegisterService.save(register);
            return new ResponseEntity<Register>(register, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/register/{register_id}")
    public ResponseEntity<Register> deleteRegister(@PathVariable Integer register_id){
        try {
            RegisterService.delete(register_id);
            return new ResponseEntity<Register>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
        }
    }
}
