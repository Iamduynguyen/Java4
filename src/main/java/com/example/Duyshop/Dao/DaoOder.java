package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.Oderdetall;
import com.example.Duyshop.Mode.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoOder {
    public static EntityManager em = JpaUtils.getEntityManager();

    public List<Oderdetall> findall(){
        try {
            String jpql = "select o from Oderdetall o";
            TypedQuery<Oderdetall> query = em.createQuery(jpql,Oderdetall.class);
            List<Oderdetall> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Oderdetall findbyId(int id){
        try {
            return em.find(Oderdetall.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(Oderdetall entity){
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
            return false;
        }
    }
    public List<Oderdetall> findbyTransaction(int id){
        try {
            String jpql = "select o from Oderdetall o where o.transaction.id ="+id;
            TypedQuery<Oderdetall> query = em.createQuery(jpql,Oderdetall.class);
            List<Oderdetall> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void update(Oderdetall entity){
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
    public void remove(int id){
        EntityTransaction trans = em.getTransaction();
        Oderdetall entity = em.find(Oderdetall.class,id);
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
