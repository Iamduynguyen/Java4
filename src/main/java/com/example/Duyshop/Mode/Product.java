package com.example.Duyshop.Mode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product", schema = "duywatch", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"catalogID"})})
public class Product {
    private int id;
    private String name;
    private int price;
    private Integer discount;
    private String content;
    private int sold;
    private int view;
    private String img1;
    private String img2;
    private String img3;
    private Integer quanlity;
    private Catalog catalog;
    private List<Oderdetall> lstOder;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "discount")
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "sold")
    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Basic
    @Column(name = "view")
    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Basic
    @Column(name = "img1")
    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    @Basic
    @Column(name = "img2")
    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    @Basic
    @Column(name = "img3")
    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    @Basic
    @Column(name = "quanlity")
    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    @ManyToOne @JoinColumn(name = "catalogID")

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @OneToMany(mappedBy = "product")

    public List<Oderdetall> getLstOder() {
        return lstOder;
    }

    public void setLstOder(List<Oderdetall> lstOder) {
        this.lstOder = lstOder;
    }
    @OneToMany(mappedBy = "product")

    public List<ProductCustomer> getLstProCus() {
        return lstProCus;
    }

    public void setLstProCus(List<ProductCustomer> lstProCus) {
        this.lstProCus = lstProCus;
    }
}
