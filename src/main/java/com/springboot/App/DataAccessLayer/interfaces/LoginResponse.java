package com.springboot.App.DataAccessLayer.interfaces;

public class LoginResponse {
    Boolean admin;
    String email;
    
    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
