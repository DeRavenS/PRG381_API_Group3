package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DStudentsRepo extends JpaRepository<DStudent, String>{
    @Query(value = "SELECT s.* FROM student s WHERE s.student_email = ?1",nativeQuery = true)
    public DStudent getStudentByEmail(@Param("email") String email);
}
