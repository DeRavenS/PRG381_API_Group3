package DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepo extends JpaRepository<DAdmin, Integer>{
    
}
