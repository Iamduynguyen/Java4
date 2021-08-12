package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.Catalog;
import com.example.Duyshop.Mode.ProductCustomer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoFavourite {
    public static EntityManager em = JpaUtils.getEntityManager();

    public ProductCustomer Findlikebycustomer(int cus, int pro){
        try {
            String jpql = "select o from ProductCustomer o where o.product.id="+pro+" and o.customer.id = "+cus;
            TypedQuery<ProductCustomer> query = em.createQuery(jpql,ProductCustomer.class);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductCustomer> findall(){
        try {
            String jpql = "select o from ProductCustomer o";
            TypedQuery<ProductCustomer> query = em.createQuery(jpql,ProductCustomer.class);
            List<ProductCustomer> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductCustomer> findlikebycus(int cus){
        try {
            String jpql = "select o from ProductCustomer o where o.like = true and o.customer.id ="+cus;
            TypedQuery<ProductCustomer> query = em.createQuery(jpql,ProductCustomer.class);
            List<ProductCustomer> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<ProductCustomer> findsoldbycus(int cus){
        try {
            String jpql = "select o from ProductCustomer o where o.sold = true and o.customer.id ="+cus;
            TypedQuery<ProductCustomer> query = em.createQuery(jpql,ProductCustomer.class);
            List<ProductCustomer> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public void update(ProductCustomer entity){
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
    }

    public void create(ProductCustomer entity){
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
    }
    public void remove(ProductCustomer entity){
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(entity);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
    }
}
