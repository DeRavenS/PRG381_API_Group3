 package com.springboot.App.DataAccessLayer.routeController;

// import java.lang.reflect.Array;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.App.DataAccessLayer.interfaces.BrowseStudentRequest;
import com.springboot.App.DataAccessLayer.interfaces.DAdmin;
import com.springboot.App.DataAccessLayer.interfaces.DStudent;
import com.springboot.App.DataAccessLayer.interfaces.LoginResponse;
import com.springboot.App.DataAccessLayer.interfaces.PasswordResponse;
// import com.springboot.App.DataAccessLayer.models.Admin;
import com.springboot.App.DataAccessLayer.models.Administrator;
import com.springboot.App.DataAccessLayer.models.BrowsedStudent;
import com.springboot.App.DataAccessLayer.models.DeleteRequest;
import com.springboot.App.DataAccessLayer.models.LoginRequest;
import com.springboot.App.DataAccessLayer.models.PasswordRequest;
import com.springboot.App.DataAccessLayer.models.Student;
import com.springboot.App.DataAccessLayer.models.registerUserRequest;
import com.springboot.App.DataAccessLayer.service.AdministratorService;
// import com.springboot.App.DataAccessLayer.service.DAdministratorService;
// import com.springboot.App.DataAccessLayer.service.DStudentsService;
// import com.springboot.App.DataAccessLayer.service.RegisterService;
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

    /* @Autowired
    private RegisterService RegisterService; */

    /*
     * Routes to INSERT/UPDATE/DELETE/SELECT the Administartor table in MySQL
     */

    @GetMapping("/api/admin")
    public ResponseEntity<DAdmin> getAdminDetails(@PathVariable("admin_id") Integer adminID){
        try {
            Administrator admin = AdminService.get(adminID);
            System.out.println(admin.getAdminContact());
            DAdmin dadmin = new DAdmin(String.valueOf(admin.getAdminID()), admin.getAdminName(), admin.getAdminContact(), admin.getAdminEmail());
            return new ResponseEntity<DAdmin>(dadmin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DAdmin>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/admin")
    public ResponseEntity<DAdmin> updateAdminDetails(@RequestBody DAdmin request, @PathVariable String admin_id){
        try {
            Administrator admin = AdminService.get(Integer.parseInt(admin_id));
            if (!(request.getAdminID().isEmpty())) {
                admin.setAdminID(Integer.parseInt(request.getAdminID()));
            }
            if (!(request.getAdminName().isEmpty())) {
                admin.setAdminName(request.getAdminName());
            }
            if (!(request.getAdminContact().isEmpty())) {
                admin.setAdminContact(request.getAdminContact());
            }
            if (!(request.getAdminEmail().isEmpty())) {
                admin.setAdminEmail(request.getAdminEmail());

            }
            AdminService.save(admin);
            return new ResponseEntity<DAdmin>(request, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DAdmin>(HttpStatus.NOT_FOUND);
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
    public pagedResponse<BrowsedStudent> listStudent(@RequestBody BrowseStudentRequest request){
        pagedResponse<BrowsedStudent> response = new pagedResponse<BrowsedStudent>(); 
        //Add pagination from request
        Integer page = request.page;
        Integer size = request.size;
        for (Student student  : StudentService.listAll(page, size)) {
            response.items.add(new BrowsedStudent(String.valueOf(student.getStudent_id()), student.getStudent_name() , student.getStudent_address(), student.getStudent_email()));
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
                Student student = StudentService.getByID(id);
                return new ResponseEntity<DStudent>(new DStudent(String.valueOf(student.getStudent_id()), student.getStudent_name() , student.getStudent_address(), student.getStudent_email(),new ArrayList<String>(Arrays.asList("Random Courses","asdsadasd"))), HttpStatus.OK);
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
        if (student.registerStudentRequest.isPresent()) {
            Student stud = new Student(20, student.registerStudentRequest.get().studentName, student.registerStudentRequest.get().studentAddress, student.registerStudentRequest.get().studentEmail, student.registerStudentRequest.get().studentPassword);
            StudentService.save(stud);
            return true;
        }
        else return false;
    }

    @PutMapping("/api/student")
    public ResponseEntity<DStudent> updateStudentDetails(@RequestBody DStudent request){
        try {
            Student student = StudentService.getByID(request.getStudentID());
            if (!(request.getStudentName().isEmpty())) {
                student.setStudent_name(request.getStudentName());
            }
            if (!(request.getStudentAddress().isEmpty())) {
                student.setStudent_address(request.getStudentAddress());
            }
            if (!(request.getStudentEmail().isEmpty())) {
                student.setStudent_email(request.getStudentEmail());

            }
            StudentService.save(student);
            return new ResponseEntity<DStudent>(request, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/student")
    public ResponseEntity<DStudent> deleteStudent(@RequestBody DeleteRequest request){
        try {
            StudentService.delete(Integer.parseInt(request.getID()));
            return new ResponseEntity<DStudent>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        }
    }

    /* 
     * Login routes
     */

    @GetMapping("/api/login")
    public ResponseEntity<LoginResponse> getStudents(@RequestBody LoginRequest request) {
        Administrator admin = AdminService.findByEmail(request.getEmail());
        LoginResponse response = new LoginResponse();

        if (!(admin.getAdminEmail().isEmpty())) {
            if (admin.getAdmin_password().equals(request.getPassword())) {
                response.setAdmin(true);
                response.setID(String.valueOf(admin.getAdminID()));
                return new ResponseEntity<LoginResponse>(response, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<LoginResponse>(HttpStatus.UNAUTHORIZED);
            }
        }

        Student student = StudentService.getByEmail(request.getEmail());
        
        if (!(student.getStudent_email().isEmpty())) {
            if (student.getStudent_password().equals(request.getPassword())) {
                response.setAdmin(false);
                response.setID(String.valueOf(student.getStudent_id()));
                return new ResponseEntity<LoginResponse>(response, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<LoginResponse>(HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<LoginResponse>(HttpStatus.NOT_FOUND);
    }

    /* 
     * Reset Password routes
     */

    @PutMapping("/api/password")
    public ResponseEntity<PasswordResponse> resetPassword(@RequestBody PasswordRequest request) {
        Administrator admin = AdminService.findByEmail(request.getEmail());
        PasswordResponse response = new PasswordResponse();

        if (!(admin.getAdminEmail().isEmpty())) {
            if (admin.getAdmin_password().equals(request.getOldPassword())) {
                if (!admin.getAdmin_password().equals(request.getNewPassword())) {
                    admin.setAdmin_password(request.getNewPassword());
                    AdminService.save(admin);
                    
                    response.setChanged(true);
                    return new ResponseEntity<PasswordResponse>(response, HttpStatus.OK);
                } else {
                    response.setChanged(false);
                    return new ResponseEntity<PasswordResponse>(response, HttpStatus.UNAUTHORIZED);
                }
            }
        }

        Student student = StudentService.getByEmail(request.getEmail());
        
        if (!(student.getStudent_email().isEmpty())) {
            if (student.getStudent_password().equals(request.getOldPassword())) {
                if (!student.getStudent_password().equals(request.getNewPassword())) {
                    student.setStudent_password(request.getNewPassword());
                    StudentService.save(student);

                    response.setChanged(true);
                    return new ResponseEntity<PasswordResponse>(response, HttpStatus.ACCEPTED);
                } else {
                    response.setChanged(false);
                    return new ResponseEntity<PasswordResponse>(response, HttpStatus.UNAUTHORIZED);
                }
            }
        }
        response.setChanged(false);
        return new ResponseEntity<PasswordResponse>(response, HttpStatus.NOT_FOUND);
    }

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
