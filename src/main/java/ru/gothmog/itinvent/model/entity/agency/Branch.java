package ru.gothmog.itinvent.model.entity.agency;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.gothmog.itinvent.model.entity.auth.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author d.grushetskiy
 */
@Entity
@Table(name = "branch")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Long id;

    @Column(name = "branch_name")
    private String branchName;

    @ManyToMany
    @JoinTable(name = "user_branch", joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users = new HashSet<>();

    public Branch() {
    }

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public Branch(String branchName, Set<User> users) {
        this.branchName = branchName;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
