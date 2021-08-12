package com.example.Duyshop.Dao;

import com.example.Duyshop.Mode.CtrlwebEntity;
import com.example.Duyshop.Mode.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoCtrolwebsite {
    public static EntityManager em = JpaUtils.getEntityManager();


    public CtrlwebEntity find(){
        try {
            return em.find(CtrlwebEntity.class,1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public void update(CtrlwebEntity entity){
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

}
