package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.Product;
import com.example.Duyshop.Mode.Staff;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoStaff {
        public static EntityManager em = JpaUtils.getEntityManager();

        public List<Staff> findall(){
            try {
                String jpql = "select o from Staff o";
                TypedQuery<Staff> query = em.createQuery(jpql,Staff.class);
                List<Staff> lst = query.getResultList();
                return lst;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

    public List<Staff> findactive(boolean active){
        try {
            String jpql = "select o from Staff o where o.active ="+active;
            TypedQuery<Staff> query = em.createQuery(jpql,Staff.class);
            List<Staff> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Staff> findnoactive(){
        try {
            String jpql = "select o from Staff o where o.active = false ";
            TypedQuery<Staff> query = em.createQuery(jpql,Staff.class);
            List<Staff> lst = query.getResultList();
            return lst;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Staff findbyId(int id){
        try {
            return em.find(Staff.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(Staff entity){
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
    public void update(Staff entity){
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
            System.out.println("xong");
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
    }
}
