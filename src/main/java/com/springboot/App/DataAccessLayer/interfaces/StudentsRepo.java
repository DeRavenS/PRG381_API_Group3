package com.springboot.App.DataAccessLayer.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.App.DataAccessLayer.models.Student;

@Repository
public interface StudentsRepo extends JpaRepository<Student, Integer>{
    @Query(value = "SELECT s.* FROM student s WHERE s.student_email = ?1",nativeQuery = true)
    public Student getStudentByEmail(@Param("email") String email);

    @Query(value = "SELECT s.* FROM student s LIMIT ?2 OFFSET ?1",nativeQuery = true)
    public List<Student> findAllPage(@Param("page") Integer page, @Param("size")Integer size);
}
