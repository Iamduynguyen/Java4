package com.example.Duyshop.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaUtils {
    private static EntityManagerFactory factory;
    static public EntityManager getEntityManager(){
        try {
            factory = Persistence.createEntityManagerFactory("duywatch");
            return factory.createEntityManager();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    static  public void shutdown(){
        if (factory!=null&&factory.isOpen()){
            factory.close();
        }
        factory = null;
    }
}