package DataAccessLayer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register {
    private int register_id;
    private int student_id;
    private String course_name;

    public Register() {
    }

    public Register(int register_id, int student_id, String course_name) {
        super();
        this.register_id = register_id;
        this.student_id = student_id;
        this.course_name = course_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Register register_id(int register_id) {
        setRegister_id(register_id);
        return this;
    }

    public Register student_id(int student_id) {
        setStudent_id(student_id);
        return this;
    }

    public Register course_name(String course_name) {
        setCourse_name(course_name);
        return this;
    }
}
