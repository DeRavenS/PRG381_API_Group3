package com.springboot.App.DataAccessLayer.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.App.DataAccessLayer.models.Student;

public class userDets implements UserDetails {

    private Student user;

    public userDets(Student stud)
    {
        this.user = stud;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> auths = new HashSet();

        //IUser current

        //then I would test type of class and if admin give ROLE_ADMIN
        //else ROLE_STUDENT
        auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        
        return auths;
    }

    @Override
    public String getPassword() {
       return user.getStudent_password();
    }

    @Override
    public String getUsername() {
        return user.getStudent_email();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
