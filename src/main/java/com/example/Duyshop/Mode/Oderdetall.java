package com.example.Duyshop.Mode;

import javax.persistence.*;

@Entity
@Table(name = "oderdetall", schema = "duywatch",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"transactionID","productID"})})
public class Oderdetall {
    private int id;
    private int quanlity;
    private int amout;
    private boolean active;
    private Transaction transaction;
    private Product product;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quanlity")
    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    @Basic
    @Column(name = "amout")
    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }


    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @ManyToOne @JoinColumn(name = "transactionID")

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    @ManyToOne @JoinColumn(name = "productID")

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
