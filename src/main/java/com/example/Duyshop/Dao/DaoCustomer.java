package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoCustomer {
    public static EntityManager em = JpaUtils.getEntityManager();

    public List<Customer> findall(){
        try {
            String jpql = "select o from Customer o";
            TypedQuery<Customer> query = em.createQuery(jpql,Customer.class);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    public Customer findbyId(int id){
        try {
            return em.find(Customer.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Customer findbyemail(String mail){
        try {
            String jpql = "select o from Customer o where o.email = "+mail;
            TypedQuery<Customer> query = em.createQuery(jpql,Customer.class);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(Customer entity){
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

    public void update(Customer entity){
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
        Customer entity = em.find(Customer.class,id);
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
