package group3prg.loginreg.model;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "student_email"))
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int student_id;

    String student_name;
    String student_address;
    String student_email;
    String student_password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_roles", 
            joinColumns = @JoinColumn(
                    name = "student_id", referencedColumnName = "student_id"), 
            inverseJoinColumns = @JoinColumn(
                    name = "s_role_id", referencedColumnName = "s_role_id")                    
        )
    Collection <srole> sroles;
    

    public student(String student_name, String student_address, String student_email, String student_password,
            Collection<srole> sroles) {
        this.student_name = student_name;
        this.student_address = student_address;
        this.student_email = student_email;
        this.student_password = student_password;
        this.sroles = sroles;
    }
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
    public Collection<srole> getSroles() {
        return sroles;
    }
    public void setSroles(Collection<srole> sroles) {
        this.sroles = sroles;
    }

    

}
