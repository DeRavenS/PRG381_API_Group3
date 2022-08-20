package group381project.test2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<student, Integer> {
    
}
