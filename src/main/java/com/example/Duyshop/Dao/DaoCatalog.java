package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoCatalog {
    public static EntityManager em = JpaUtils.getEntityManager();

    public List<Catalog> findall(){
        try {
            String jpql = "select o from Catalog o";
            TypedQuery<Catalog> query = em.createQuery(jpql,Catalog.class);
            List<Catalog> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Catalog findbyid(int id){
        try {
            return em.find(Catalog.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
