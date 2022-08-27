 package com.springboot.App.DataAccessLayer.routeController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.App.DataAccessLayer.interfaces.BrowseStudentRequest;
import com.springboot.App.DataAccessLayer.interfaces.DStudent;
import com.springboot.App.DataAccessLayer.models.Administrator;
import com.springboot.App.DataAccessLayer.models.BrowsedStudent;
import com.springboot.App.DataAccessLayer.models.Student;
import com.springboot.App.DataAccessLayer.models.registerUserRequest;
import com.springboot.App.DataAccessLayer.service.AdministratorService;
import com.springboot.App.DataAccessLayer.service.RegisterService;
import com.springboot.App.DataAccessLayer.service.StudentsService;

// import java.util.List;
// import java.util.NoSuchElementException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// // import com.springboot.App.DataAccessLayer.interfaces.DAdmin;
// import com.springboot.App.DataAccessLayer.interfaces.DStudent;
// import com.springboot.App.DataAccessLayer.models.Administrator;
// import com.springboot.App.DataAccessLayer.models.Register;
// import com.springboot.App.DataAccessLayer.service.AdministratorService;
// import com.springboot.App.DataAccessLayer.service.RegisterService;
// import com.springboot.App.DataAccessLayer.service.StudentsService;

@RestController
@RequestMapping
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

    @GetMapping("/api/admin/{admin_id}")
    public ResponseEntity<Administrator> getAdminDetails(@PathVariable("admin_id") Integer adminID){
        try {
            Administrator admin = AdminService.get(adminID);
            System.out.println(admin.getAdminContact());
            Administrator dadmin = new Administrator(admin.getAdminID(), admin.getAdminName(), admin.getAdmin_password(), admin.getAdminContact(), admin.getAdminEmail());
            return new ResponseEntity<Administrator>(dadmin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
    }

    // @PutMapping("/api/admin/{admin_id}")
    // public ResponseEntity<DAdmin> updateAdminDetails(@RequestBody DAdmin admin, @PathVariable Integer admin_id){
    //     try {
    //         DAdmin existAdmin = AdminService.get(admin_id);
    //         DAdmin dadmin = new DAdmin(admin.getAdminID(), admin.getAdminName(), admin.getAdminContact(), admin.getAdminEmail());
    //         AdminService.save(admin);
    //         return new ResponseEntity<DAdmin>(dadmin, HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<DAdmin>(HttpStatus.NOT_FOUND);
    //     }
    // }

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
    public pagedResponse<BrowsedStudent> listStudent(@RequestBody BrowseStudentRequest request){
        pagedResponse<BrowsedStudent> response = new pagedResponse<BrowsedStudent>(); 
        //Add pagination from request
        Integer size = request.size;
        Integer page = request.page;
        for (Student student  : StudentService.listAll()) {
            response.items.add(new BrowsedStudent(Integer.toString(student.getStudent_id()), student.getStudent_name() , student.getStudent_address(), student.getStudent_email()));
        }
        response.totalItems=response.items.size();
        response.itemsPerPage=size;
        response.page=page;
        response.pageCount=(int) Math.ceil(response.totalItems/response.itemsPerPage);
        return response;
    }

    @GetMapping("/api/student")
    public ResponseEntity<DStudent> getStudentDetails(@RequestParam("studentID") Optional<String> student_id){
        try {
            String id;
            if (student_id.isPresent()) {
                id=student_id.get();
                Student student = StudentService.getByID(Integer.parseInt(id));
                return new ResponseEntity<DStudent>(new DStudent(Integer.toString(student.getStudent_id()), student.getStudent_name() , student.getStudent_address(), student.getStudent_email(),new ArrayList<String>(Arrays.asList("Random Courses","asdsadasd"))), HttpStatus.OK);
            }// Add courses
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        }
    }

    //get auto ID
   @PostMapping("/api/student/create")
    public Boolean addStudent(@RequestBody registerUserRequest student){

        System.out.println(student);
        // try {
            if (student.registerStudentRequest.isPresent()) {
            Student stud = new Student(20, student.registerStudentRequest.get().studentName, student.registerStudentRequest.get().studentAddress, student.registerStudentRequest.get().studentEmail, student.registerStudentRequest.get().studentPassword);
            StudentService.save(stud);
            return true;
        }
        else return false;
        // else return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        // } catch (Exception e) {
        //     //TODO: handle exception
        //     return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
        // }
        
        
        
    }

    // @PutMapping("/api/student/{student_id}")
    // public ResponseEntity<DStudent> updateStudentDetails(@RequestBody DStudent student, @PathVariable String student_id){
    //     try {
    //         DStudent existStudent = StudentService.get(student_id);
    //         StudentService.save(student);
    //         return new ResponseEntity<DStudent>(student, HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @DeleteMapping("/api/student/{student_id}")
    // public ResponseEntity<DStudent> deleteStudent(@PathVariable String student_id){
    //     try {
    //         StudentService.delete(student_id);
    //         return new ResponseEntity<DStudent>(HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
    //     }
    // }

    /*
     * Routes to INSERT/UPDATE/DELETE/SELECT the Register table in MySQL
     */

    // @GetMapping("/api/register")
    // public List<Register> listRegister(){
    //     return RegisterService.listAll();
    // }

    // @GetMapping("/api/register/{register_id}")
    // public ResponseEntity<Register> getRegister(@PathVariable Integer register_id){
    //     try {
    //         Register register = RegisterService.get(register_id);
    //         return new ResponseEntity<Register>(register, HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @PostMapping("/api/register")
    // public void addStudent(@RequestBody Register register){
    //     RegisterService.save(register);
    // }

    // @PutMapping("/api/register/{register_id}")
    // public ResponseEntity<Register> updateRegister(@RequestBody Register register, @PathVariable Integer register_id){
    //     try {
    //         Register existRegister = RegisterService.get(register_id);
    //         RegisterService.save(register);
    //         return new ResponseEntity<Register>(register, HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @DeleteMapping("/api/register/{register_id}")
    // public ResponseEntity<Register> deleteRegister(@PathVariable Integer register_id){
    //     try {
    //         RegisterService.delete(register_id);
    //         return new ResponseEntity<Register>(HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
    //     }
    // }
}
