package DataAccessLayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataAccessLayer.interfaces.AdministratorRepo;
import DataAccessLayer.interfaces.DAdmin;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepo repo;

    public List<DAdmin> listAll(){
        return repo.findAll();
    }

    public void save(DAdmin administrator){
        repo.save(administrator);
    }

    public DAdmin get(Integer admin_id){
        return repo.findById(admin_id).get();
    }

    public void delete(Integer admin_id){
        repo.deleteById(admin_id);
    }
}
