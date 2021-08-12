package com.example.Duyshop.Mode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction",schema = "duywatch",uniqueConstraints =
        {@UniqueConstraint(columnNames = {"staffID","customerID"})})
public class Transaction {
    private int id;
    private int status;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private int amouttotal;
    private Date created;
    private Staff staff;
    private Customer customer;
    private List<Oderdetall> lstOder;



    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "customerName")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customerAddress")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "customerPhone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "amouttotal")
    public int getAmouttotal() {
        return amouttotal;
    }

    public void setAmouttotal(int amouttotal) {
        this.amouttotal = amouttotal;
    }

    @Basic
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @ManyToOne @JoinColumn(name = "staffID")

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne @JoinColumn(name = "customerID")

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    @OneToMany(mappedBy = "transaction")
    public List<Oderdetall> getLstOder() {
        return lstOder;
    }

    public void setLstOder(List<Oderdetall> lstOder) {
        this.lstOder = lstOder;
    }

}
