package com.springboot.App.DataAccessLayer.interfaces;

public class LoginResponse {
    Boolean admin;
    String ID;
    
    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    public String getID() {
        return ID;
    }
    public void setID(String email) {
        this.ID = email;
    }
    
}
