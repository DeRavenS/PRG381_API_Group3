package group381project.test2;

import javax.persistence.*;


@Entity
@Table(name="Student")
public class student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int student_id;

    @Column(nullable = false)    
    String student_address;

    @Column(nullable = false, unique = true, length = 45) 
    String student_email;

    @Column(nullable = false) 
    String student_name;

    @Column(nullable = false, length = 64) 
    String student_password;

    public student() {
    }

    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getStudent_password() {
        return student_password;
    }
    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    
}
