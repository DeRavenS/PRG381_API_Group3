package com.springboot.App.DataAccessLayer.interfaces;

public class DAdmin {
    int adminID;
    String adminName;
    String adminContact;
    String adminEmail;
    
    public DAdmin(int adminID, String adminName, String adminContact, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminContact = adminContact;
        this.adminEmail = adminEmail;
    }
}
