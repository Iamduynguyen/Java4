package com.example.Duyshop.Dao;


import com.example.Duyshop.Mode.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoProduct {
    public static EntityManager em = JpaUtils.getEntityManager();

    public List<Product> findall(){
        try {
            String jpql = "select o from Product o";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
           return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findbycatalogid(int id){
        try {
            String jpql = "select o from Product o where o.catalog.id = "+ id;
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findbyname(int cataid,String name){
        try {
            String jpql = "select o from Product o where o.catalog.id = "+cataid+" and o.name like '%"+ name+"%'";
            if (cataid<0){
                jpql = "select o from Product o where o.name like '%"+ name+"%'";
            }
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    public List<Product> findbycataidlimit(int id,int page,int max){
        try {
            page--;
            String jpql;
            if (id>0){
                 jpql = "select o from Product o where o.catalog.id = "+ id;
            }else {
                 jpql = "select o from Product o";
            }
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setFirstResult(page*max);
            query.setMaxResults(max);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findlimit(int page){
        try {
            page--;
            String jpql = "select o from Product o";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setFirstResult(page*5);
            query.setMaxResults(5);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findlimitBycata(int id,int page){
        try {
            page--;
            String jpql = "select o from Product o where o.catalog.id = "+ id;
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setFirstResult(page*5);
            query.setMaxResults(5);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Product findbyId(int id){
        try {
            return em.find(Product.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(Product entity){
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

    public void update(Product entity){
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
        Product entity = em.find(Product.class,id);
        try {
            trans.begin();
            em.remove(entity);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
    }

    public List<Product> viewtop5(){
        try {
            String jpql = "select o from Product o order by o.view desc ";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setMaxResults(5);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> soldtop5(){
        try {
            String jpql = "select o from Product o order by o.sold desc ";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setMaxResults(5);
            return query.getResultList(); // no li cho nay
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
