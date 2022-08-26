package DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import DataAccessLayer.models.Register;

public interface RegisterRepo extends JpaRepository<Register, Integer>{
    
}
