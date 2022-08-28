package com.springboot.App.DataAccessLayer.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.App.DataAccessLayer.models.Administrator;

@Repository
public interface AdministratorRepo extends JpaRepository<Administrator, Integer>{
    @Query(value = "SELECT a.* FROM administrator a WHERE a.admin_email = ?1",nativeQuery = true)
    public Administrator getAdminByEmail(@Param("email") String email);
}
