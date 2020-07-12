package moneytap.billshare.model;

import javax.persistence.*;

@Entity
@Table(name="role_")
public class Role {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="role_id")
    private  int role_id;

    @Column(name="role_details")
    private  String role_detals;

    public Role() {
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_detals() {
        return role_detals;
    }

    public void setRole_detals(String role_detals) {
        this.role_detals = role_detals;
    }
}
