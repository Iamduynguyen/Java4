package com.example.Duyshop.Mode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer", schema = "duywatch")
public class Customer {
    private int id;
    private String email;
    private String name;
    private String password;
    private String address;
    private String phone;
    private int rank;
    private String image;
    private Boolean sex;
    private List<Transaction> lstTracsaction;
    private List<ProductCustomer> lstProCus;

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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "rank")
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
    @Column(name = "sex")
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @OneToMany(mappedBy = "customer")

    public List<Transaction> getLstTracsaction() {
        return lstTracsaction;
    }

    public void setLstTracsaction(List<Transaction> lstTracsaction) {
        this.lstTracsaction = lstTracsaction;
    }



    @OneToMany(mappedBy = "customer")
    public List<ProductCustomer> getLstProCus() {
        return lstProCus;
    }

    public void setLstProCus(List<ProductCustomer> lstProCus) {
        this.lstProCus = lstProCus;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rank=" + rank +
                ", image='" + image + '\'' +
                ", sex=" + sex +
                ", lstTracsaction=" + lstTracsaction +
                '}';
    }
}
