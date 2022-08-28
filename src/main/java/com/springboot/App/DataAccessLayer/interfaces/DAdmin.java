package com.springboot.App.DataAccessLayer.interfaces;


public class DAdmin {
    private String adminID;

    private String adminName;

    private String adminContact;

    private String adminEmail;

   

    public DAdmin(String adminID, String adminName, String adminContact, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminContact = adminContact;
        this.adminEmail = adminEmail;
    }
    
    public String getAdminID() {
        return adminID;
    }
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminContact() {
        return adminContact;
    }
    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
