package com.example.Duyshop.Help;

import com.example.Duyshop.Dao.DaoCtrolwebsite;
import com.example.Duyshop.Dao.DaoProduct;
import com.example.Duyshop.Mode.CtrlwebEntity;
import com.example.Duyshop.Mode.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Applistener implements HttpSessionListener, ServletContextListener {
    private int vister =0;
    DaoCtrolwebsite dao = new DaoCtrolwebsite();
    CtrlwebEntity ctrlwebEntity = new CtrlwebEntity();
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        //ghilai
        ServletContext application = e.getServletContext();
        ctrlwebEntity.setView(vister);
        dao.update(ctrlwebEntity);
    }
    @Override
    public void contextInitialized(ServletContextEvent e) {
        //lay ra
        ServletContext application = e.getServletContext();
        ctrlwebEntity = dao.find();
        vister = ctrlwebEntity.getView();
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        vister++;
    }
}
