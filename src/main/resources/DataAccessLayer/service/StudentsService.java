package DataAccessLayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataAccessLayer.interfaces.DStudent;
import DataAccessLayer.interfaces.StudentsRepo;

@Service
public class StudentsService {
    
    @Autowired
    private StudentsRepo repo;

    public List<DStudent> listAll(){
        return repo.findAll();
    }

    public void save(DStudent students){
        repo.save(students);
    }

    public DStudent get(String student_id){
        return repo.findById(student_id).get();
    }

    public void delete(String student_id){
        repo.deleteById(student_id);
    }
}
