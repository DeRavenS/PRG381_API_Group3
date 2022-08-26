package com.springboot.App.DataAccessLayer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int register_id;
    private int student_id;
    private String course_name;

    public Register1() {
    }


    

    public Register1(int register_id, int student_id, String course_name) {
        this.register_id = register_id;
        this.student_id = student_id;
        this.course_name = course_name;
    }




    public int getRegister_id() {
        return register_id;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

}