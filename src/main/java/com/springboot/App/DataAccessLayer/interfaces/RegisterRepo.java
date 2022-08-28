package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// import com.springboot.App.DataAccessLayer.models.Register;
import com.springboot.App.DataAccessLayer.models.Register1;

import java.util.List;

@Repository
public interface RegisterRepo extends JpaRepository<Register1, String>{
    @Query(value = "SELECT r.course_name FROM register r WHERE r.student_id = ?1",nativeQuery = true)
    public List<String> findByStudentID(@Param("id") String id);

    @Modifying
    @Query(value = "DELETE FROM register WHERE course_name IN ?1 and student_id=?2",nativeQuery = true)
    public void deleteCourses(@Param("course_name") List<String> name,@Param("student_id") String id);

    @Modifying
    @Query(value = "INSERT INTO register (student_id, course_name) VALUES (?2,?1)" ,nativeQuery = true)
    public void updateCourses(@Param("course_name") String course, @Param("student_id") String id);
}
