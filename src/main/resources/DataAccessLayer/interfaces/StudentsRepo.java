package DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<DStudent, String>{
    
}
