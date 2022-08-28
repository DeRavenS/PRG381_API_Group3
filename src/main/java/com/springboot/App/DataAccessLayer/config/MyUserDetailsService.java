package com.springboot.App.DataAccessLayer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springboot.App.DataAccessLayer.models.Student;
import com.springboot.App.DataAccessLayer.service.StudentsService;

public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    StudentsService studService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Student current = studService.getByEmail(username);
        //IUser current

        //then I would test type of class and if admin give ROLE_ADMIN
        //else ROLE_STUDENT
        if (current==null) {
            throw new UsernameNotFoundException("No user found");
        }

        return new userDets(current);
    }
    
}
