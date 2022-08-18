package group3.project.test;

import static org.assertj.core.api.Assertions.assertThat;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import group3.project.test.model.student;
import group3.project.test.repository.studentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class studentRepositoryTests {
    
    @Autowired
    private studentRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateStudent() {
        student student = new student();

        student.setStudent_name("John");
        student.setStudent_address("123 Main St");
        student.setStudent_password("John123456");
        student.setStudent_email("johnkeneddy@gamil.com");

        student savedStudent =  repo.save(student);        
        
        student exitStudent = entityManager.find(student.class, savedStudent.getStudent_id());

        assertThat(exitStudent.getStudent_id()).isEqualTo(savedStudent.getStudent_id());


    }
}
