package moneytap.billshare.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class  Users {
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private int id;
        @Column(name="username")
        private String name;
        @Column(name="u_password")
        private  String password;
        @Column(name="active")
        private int active;
        @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
                private Set<Role> roles;

    public Users(Users user) {
        this.id = user.id;
        this.name = user.name;
        this.password = user.password;
        this.active = user.active;
        this.roles = user.roles;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
