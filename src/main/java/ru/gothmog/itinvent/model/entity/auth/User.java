package ru.gothmog.itinvent.model.entity.auth;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.gothmog.itinvent.model.entity.agency.Branch;
import ru.gothmog.itinvent.model.entity.agency.Company;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author d.grushetskiy
 */
@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", length = 64)
    private String username= "";

    @Column(name = "user_pass", length = 64)
    private String password = "";

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "addinfo")
    private String addInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="user_company", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> companies = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_branch", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "branch_id"))
    private Set<Branch> branches = new HashSet<>();

    @Lob
    @Column(name = "image_data", updatable = false)
    private byte[] imageData;

    @Column(name = "user_blocked")
    private boolean userBlocked;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phone")
    private String phone;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, boolean userBlocked) {
        this.username = username;
        this.password = password;
        this.userBlocked = userBlocked;
    }

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String password, byte[] imageData, boolean userBlocked) {
        this.username = username;
        this.password = password;
        this.imageData = imageData;
        this.userBlocked = userBlocked;
    }

    public User(String username, String password, Set<Role> roles, byte[] imageData, boolean userBlocked) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.imageData = imageData;
        this.userBlocked = userBlocked;
    }

    public User(String username, String password, Set<Company> companies, Set<Branch> branches) {
        this.username = username;
        this.password = password;
        this.companies = companies;
        this.branches = branches;
    }

    public User(String username, String password, Set<Role> roles, Set<Company> companies, Set<Branch> branches) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.companies = companies;
        this.branches = branches;
    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password, Set<Role> roles, String addInfo, Set<Company> companies, Set<Branch> branches, byte[] imageData, boolean userBlocked, String email, String phone) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.addInfo = addInfo;
        this.companies = companies;
        this.branches = branches;
        this.imageData = imageData;
        this.userBlocked = userBlocked;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public boolean isUserBlocked() {
        return userBlocked;
    }

    public void setUserBlocked(boolean userBlocked) {
        this.userBlocked = userBlocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
