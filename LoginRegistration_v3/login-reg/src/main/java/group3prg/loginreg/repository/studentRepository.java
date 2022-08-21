package group3prg.loginreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group3prg.loginreg.model.student;

public interface studentRepository extends JpaRepository<student,Integer> {
    
}
