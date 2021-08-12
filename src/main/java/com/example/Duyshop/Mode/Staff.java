package com.example.Duyshop.Mode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "staff", schema = "duywatch")
public class Staff {
    private int id;
    private String email;
    private String name;
    private String password;
    private String image;
    private Boolean role;
    private Boolean active;
    private String phone;
    private List<Transaction> lstTransaction;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "role")
    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(mappedBy = "staff")

    public List<Transaction> getLstTransaction() {
        return lstTransaction;
    }

    public void setLstTransaction(List<Transaction> lstTransaction) {
        this.lstTransaction = lstTransaction;
    }


}
