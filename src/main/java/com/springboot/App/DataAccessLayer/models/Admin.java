package com.springboot.App.DataAccessLayer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Admin {
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

    public Admin(int adminID, String adminName, String admin_password, String adminContact, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.admin_password = admin_password;
        this.adminContact = adminContact;
        this.adminEmail = adminEmail;
    }

    public Admin() {
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

    


    // public int getAdmin_id() {
    //     return adminID;
    // }

    // public void setAdmin_id(int admin_id) {
    //     this.adminID = admin_id;
    // }

    // public String getAdmin_name() {
    //     return adminName;
    // }

    // public void setAdmin_name(String admin_name) {
    //     this.adminName = admin_name;
    // }

    // public String getAdmin_email() {
    //     return adminEmail;
    // }

    // public void setAdmin_email(String admin_email) {
    //     this.adminEmail = admin_email;
    // }

    // public String getAdmin_password() {
    //     return admin_password;
    // }

    // public void setAdmin_password(String admin_password) {
    //     this.admin_password = admin_password;
    // }

    // public String getAdmin_contact() {
    //     return adminContact;
    // }

    // public void setAdmin_contact(String admin_contact) {
    //     this.adminContact = admin_contact;
    // }

    // public Administrator admin_id(int admin_id) {
    //     setAdmin_id(admin_id);
    //     return this;
    // }

    // public Administrator admin_name(String admin_name) {
    //     setAdmin_name(admin_name);
    //     return this;
    // }

    // public Administrator admin_password(String admin_password) {
    //     setAdmin_password(admin_password);
    //     return this;
    // }

    // public Administrator admin_contact(String admin_contact) {
    //     setAdmin_contact(admin_contact);
    //     return this;
    // }
}
