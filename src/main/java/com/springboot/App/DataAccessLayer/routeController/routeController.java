 package com.springboot.App.DataAccessLayer.routeController;

import java.util.ArrayList;
import java.util.List;
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
import com.springboot.App.DataAccessLayer.models.Administrator;
import com.springboot.App.DataAccessLayer.models.BrowsedStudent;
import com.springboot.App.DataAccessLayer.models.DeleteRequest;
import com.springboot.App.DataAccessLayer.models.LoginRequest;
import com.springboot.App.DataAccessLayer.models.PasswordRequest;
import com.springboot.App.DataAccessLayer.models.Student;
import com.springboot.App.DataAccessLayer.models.registerUserRequest;
import com.springboot.App.DataAccessLayer.service.AdministratorService;
import com.springboot.App.DataAccessLayer.service.RegisterService;
import com.springboot.App.DataAccessLayer.service.StudentsService;

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

    @GetMapping("/api/admin{adminID}")
    public ResponseEntity<DAdmin> getAdminDetails(@PathVariable("adminID") Optional<Integer> adminID) throws InterruptedException{
        try {
            String id;
            if (adminID.isPresent()) {
                id=String.valueOf(adminID.get());
                Administrator admin = AdminService.get(Integer.parseInt(id));
                DAdmin dadmin = new DAdmin(String.valueOf(admin.getAdminID()), admin.getAdminName(), admin.getAdminContact(), admin.getAdminEmail());
                return new ResponseEntity<DAdmin>(dadmin, HttpStatus.OK);
            }
            //else return new ResponseEntity<DAdmin>(HttpStatus.BAD_REQUEST);
            else {
                id="1";
                Administrator admin = AdminService.get(Integer.parseInt(id));
                DAdmin dadmin = new DAdmin(String.valueOf(admin.getAdminID()), admin.getAdminName(), admin.getAdminContact(), admin.getAdminEmail());
                return new ResponseEntity<DAdmin>(dadmin, HttpStatus.OK);
            }
            
            
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DAdmin>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/api/admin/create")
    public Boolean addAdmin(@RequestBody registerUserRequest admin){
        if (admin.registerAdminRequest.isPresent()) {
            Administrator ad = new Administrator(20, admin.registerAdminRequest.get().adminName, admin.registerAdminRequest.get().adminContact, admin.registerAdminRequest.get().adminEmail, admin.registerAdminRequest.get().adminPassword);
            AdminService.save(ad);
            return true;
        }
        else return false;
    }

    @PutMapping("/api/admin")
    public ResponseEntity<DAdmin> updateAdminDetails(@RequestBody DAdmin request){
        try {
            if (request==null) {
                return new ResponseEntity<DAdmin>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            Administrator admin = AdminService.get(Integer.parseInt(request.getAdminID()));
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

    // @DeleteMapping("/api/admin")
    // public ResponseEntity<Administrator> deleteAdmin(@PathVariable String adminID){
    //     try {
    //         AdminService.delete(Integer.parseInt(adminID));
    //         return new ResponseEntity<Administrator>(HttpStatus.OK);
    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
    //     }
    // }

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
        response.totalItems=StudentService.totalCount();
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
                List<String> courses = RegisterService.getStudentCourse(String.valueOf(student.getStudent_id()));
                return new ResponseEntity<DStudent>(new DStudent(String.valueOf(student.getStudent_id()), student.getStudent_name() , student.getStudent_address(), student.getStudent_email(),courses), HttpStatus.OK);
            }
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        }
    }

    //get auto ID
   @PostMapping("/api/student/create")
    public Boolean addStudent(@RequestBody registerUserRequest student){
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
            if (!(request.getCourses().isEmpty())) {
                List<String> currentCourses = RegisterService.getStudentCourse(request.getStudentID());
                List<String> deleteCourses = new ArrayList<>();
                List<String> addCourses = new ArrayList<>();

                for (String course : request.getCourses()) {
                    if (!currentCourses.contains(course)) {
                        addCourses.add(course);
                    }
                }
                for (String course : currentCourses) {
                    if (!request.getCourses().contains(course)) {
                        deleteCourses.add(course);
                    }
                }
                if (deleteCourses.size() != 0) {
                    RegisterService.deleteCourses(deleteCourses,request.getStudentID());
                }
                if (addCourses.size() != 0) {
                    RegisterService.updateCourses(addCourses, request.getStudentID());
                }
            }
            StudentService.save(student);
            return new ResponseEntity<DStudent>(request, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/student/delete")
    public ResponseEntity<DStudent> deleteStudent(@RequestBody DeleteRequest request) throws InterruptedException{
        System.out.println(request.getID());
        try {   
            RegisterService.deleteByStudentID(Integer.parseInt(request.getID()));
            Thread.sleep(1000);
            StudentService.delete(Integer.parseInt(request.getID()));
            return new ResponseEntity<DStudent>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DStudent>(HttpStatus.NOT_FOUND);
        }
    }

    /* 
     * Login routes
     */

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> getStudents(@RequestBody LoginRequest request) {
        Administrator admin = AdminService.findByEmail(request.getEmail());
        LoginResponse response = new LoginResponse();

        if (admin!=null&&!(admin.getAdminEmail().isEmpty())) {
            if (admin.getAdmin_password().equals(request.getPassword())) {
                response.setAdmin(true);
                response.setID(String.valueOf(admin.getAdminID()));
                return new ResponseEntity<LoginResponse>(response, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<LoginResponse>(HttpStatus.UNAUTHORIZED);
            }
        }

        Student student = StudentService.getByEmail(request.getEmail());
        
        if (student!=null&&!(student.getStudent_email().isEmpty())) {
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

        if (admin!=null&&(!admin.getAdminEmail().isEmpty())) {
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
        
        if (student!=null&&(!student.getStudent_email().isEmpty())) {

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
