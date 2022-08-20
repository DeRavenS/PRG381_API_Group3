package com.springboot.App.DataAccessLayer.models;

public class BrowsedStudent {
    public String studentID;
    public String studentName;
    public String studentAddress;
    public String studentEmail;

    public BrowsedStudent() {
    }

    public BrowsedStudent(String studentID, String studentName, String studentAddress, String studentEmail) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return this.studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return this.studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public BrowsedStudent studentID(String studentID) {
        setStudentID(studentID);
        return this;
    }

    public BrowsedStudent studentName(String studentName) {
        setStudentName(studentName);
        return this;
    }

    public BrowsedStudent studentAddress(String studentAddress) {
        setStudentAddress(studentAddress);
        return this;
    }

    public BrowsedStudent studentEmail(String studentEmail) {
        setStudentEmail(studentEmail);
        return this;
    }
    
}
