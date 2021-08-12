package com.example.Duyshop.Mode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalog", schema = "duywatch")
public class Catalog {
    private int id;
    private String name;
    private List<Product> lstpro;

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

    @OneToMany(mappedBy = "catalog")

    public List<Product> getLstpro() {
        return lstpro;
    }

    public void setLstpro(List<Product> lstpro) {
        this.lstpro = lstpro;
    }
}
