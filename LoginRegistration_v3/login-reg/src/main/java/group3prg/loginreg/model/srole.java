package group3prg.loginreg.model;

import javax.persistence.*;

@Entity
@Table(name = "srole")
public class srole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int s_role_id;
    
    String name;

    public int getS_role_id() {
        return s_role_id;
    }
    public void setS_role_id(int s_role_id) {
        this.s_role_id = s_role_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
}
