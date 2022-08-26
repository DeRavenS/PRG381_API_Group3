package com.springboot.App.DataAccessLayer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    private int student_id;
    private String student_name;
    private String student_address;
    private String student_email;
    private String student_password;

    public Student() {
    }

    public Student(int student_id, String student_name, String student_address, String student_email, String student_password) {
        super();
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_address = student_address;
        this.student_email = student_email;
        this.student_password = student_password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public Student student_id(int student_id) {
        setStudent_id(student_id);
        return this;
    }

    public Student student_name(String student_name) {
        setStudent_name(student_name);
        return this;
    }

    public Student student_address(String student_address) {
        setStudent_address(student_address);
        return this;
    }

    public Student student_email(String student_email) {
        setStudent_email(student_email);
        return this;
    }

    public Student student_password(String student_password) {
        setStudent_password(student_password);
        return this;
    }
}
