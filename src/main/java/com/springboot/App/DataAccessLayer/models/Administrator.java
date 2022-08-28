package com.springboot.App.DataAccessLayer.models;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private int adminID;

    @Column(name="admin_name")
    private String adminName;

    @Column(name="admin_password")
    private String admin_password;

    @Column(name="admin_contact")
    private String adminContact;

    @Column(name="admin_email")
    private String adminEmail;

    

    public Administrator(int adminID, String adminName, String admin_password, String adminContact, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.admin_password = admin_password;
        this.adminContact = adminContact;
        this.adminEmail = adminEmail;
    }

    public Administrator() {
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
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
