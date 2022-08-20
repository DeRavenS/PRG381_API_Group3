package group381project.test2;

import static org.assertj.core.api.Assertions.assertThat;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class studentRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private studentRepository repo;

    @Test
    public void testCreateUser(){
        student stu = new student();

        stu.setStudent_address("kempton park");
        stu.setStudent_email("lesedimbele@gmail.com");
        stu.setStudent_name("lesedimbele");
        stu.setStudent_password("database2001");

        student savedStu = repo.save(stu);
        student existStu = entityManager.find(student.class, savedStu.getStudent_id());

        assertThat(existStu.getStudent_email()).isEqualTo(existStu.getStudent_email());

    }

}
