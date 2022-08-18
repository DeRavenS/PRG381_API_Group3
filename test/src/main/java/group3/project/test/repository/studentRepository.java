package group3.project.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group3.project.test.model.student;

@Repository 
public interface studentRepository extends JpaRepository<student, Integer> {
    
}
    

