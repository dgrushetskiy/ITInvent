package ru.gothmog.itinvent.model.entity.auth;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author d.grushetskiy
 */
@Entity
@Table(name = "roles")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private long id;

    @Column(name="role_name")
    private String role;

    @Column(name = "addinfo")
    private String addInfo;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "roles_id"), inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(String role, String addInfo) {
        this.role = role;
        this.addInfo = addInfo;
    }

    public Role(String role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    public Role(String role, String addInfo, Set<User> users) {
        this.role = role;
        this.addInfo = addInfo;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
