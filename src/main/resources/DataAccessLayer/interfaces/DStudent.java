package DataAccessLayer.interfaces;

import java.util.*;

public class DStudent {
    String studentID;
    String studentName;
    String studentAddress;
    String studentEmail;
    List<String> courses = new ArrayList<String>();
    
    public DStudent(String studentID, String studentName, String studentAddress, String studentEmail,
            List<String> courses) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
        this.courses = courses;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentAddress() {
        return studentAddress;
    }
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public List<String> getCourses() {
        return courses;
    }
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
    
}
