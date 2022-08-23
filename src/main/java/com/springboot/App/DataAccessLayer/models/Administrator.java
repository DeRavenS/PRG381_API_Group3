package com.springboot.App.DataAccessLayer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {
    private int adminID;
    private String adminName;
    private String admin_password;
    private String admin_contact;
    private String admin_email;

    public Administrator() {
    }

    public Administrator(int admin_id, String admin_name, String admin_password, String admin_contact, String admin_email) {
        super();
        this.adminID = admin_id;
        this.adminName = admin_name;
        this.admin_password = admin_password;
        this.admin_contact = admin_contact;
        this.admin_email = admin_email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAdmin_id() {
        return adminID;
    }

    public void setAdmin_id(int admin_id) {
        this.adminID = admin_id;
    }

    public String getAdmin_name() {
        return adminName;
    }

    public void setAdmin_name(String admin_name) {
        this.adminName = admin_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_contact() {
        return admin_contact;
    }

    public void setAdmin_contact(String admin_contact) {
        this.admin_contact = admin_contact;
    }

    public Administrator admin_id(int admin_id) {
        setAdmin_id(admin_id);
        return this;
    }

    public Administrator admin_name(String admin_name) {
        setAdmin_name(admin_name);
        return this;
    }

    public Administrator admin_password(String admin_password) {
        setAdmin_password(admin_password);
        return this;
    }

    public Administrator admin_contact(String admin_contact) {
        setAdmin_contact(admin_contact);
        return this;
    }
}
