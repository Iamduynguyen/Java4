package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoTransaction {
    public static EntityManager em = JpaUtils.getEntityManager();

    public List<Transaction> findall(){
        try {
            String jpql = "select o from Transaction o";
            TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
            List<Transaction> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Transaction findbyId(int id){
        try {
            return em.find(Transaction.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(Transaction entity){
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
    public List<Transaction> findbyCustomer(int customer){
        try {
            String jpql = "select o from Transaction o where o.customer.id ="+customer;
            TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
            List<Transaction> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Transaction findbyCustomer(int customer, int status){
        try {
            String jpql = "select o from Transaction o where o.status="+status+" and o.customer.id ="+customer;
            TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Transaction> findbystatus( int status){
        try {
            String jpql = "select o from Transaction o where o.status="+status;
            TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Transaction> findbystatusandstaff(int status, Staff staff){
        try {
            String jpql = "select o from Transaction o where o.status="+status+"and o.staff.id ="+staff.getId();
            TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Transaction> findbycustomer( Customer cus){
        try {
            String jpql = "select o from Transaction o where o.status > 1 and o.customer.id = "+cus.getId();
            TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void update(Transaction entity){
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
    public void remove(Transaction entity){
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
