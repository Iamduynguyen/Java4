package com.example.Duyshop.Mode;

import javax.persistence.*;

@Entity
@Table(name = "ctrlweb", schema = "duywatch", catalog = "")
public class CtrlwebEntity {
    private int id;
    private Integer view;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "view")
    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CtrlwebEntity that = (CtrlwebEntity) o;

        if (id != that.id) return false;
        if (view != null ? !view.equals(that.view) : that.view != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (view != null ? view.hashCode() : 0);
        return result;
    }
}
