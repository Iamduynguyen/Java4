package com.example.Duyshop.Mode;

import javax.persistence.*;

@Entity
@Table(name = "product_customer", schema = "duywatch",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"customerID","productID"})})
public class ProductCustomer {
    private int id;
    private Boolean likee;
    private Customer customer;
    private Product product;
    private Boolean sold;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "likee")
    public Boolean getLike() {
        return likee;
    }

    public void setLike(Boolean like) {
        this.likee = like;
    }



    @Basic
    @Column(name = "sold")
    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    @ManyToOne @JoinColumn(name = "customerID")

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @ManyToOne @JoinColumn(name = "productID")

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
