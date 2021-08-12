package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoOder;
import com.example.Duyshop.Dao.DaoProduct;
import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/transdetall")
public class DetallTrans extends HttpServlet {
    Transaction transaction = new Transaction();
    List<Oderdetall> listoder = new ArrayList<>();
    ProductCustomer procus = new ProductCustomer();
    Product a = new Product();
    Customer customer = new Customer();
    int id = -1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("customer_id")==null){
            resp.sendRedirect(req.getContextPath()+"/signin");
            return;
        }
        customer = (Customer) req.getSession().getAttribute("customer_id");
        req.setAttribute("cus",customer);
        id = Integer.parseInt(req.getParameter("id"));
        transaction = new DaoTransaction().findbyId(id);
        listoder = transaction.getLstOder();
        req.setAttribute("trans",transaction);
        req.setAttribute("lst",listoder);
        req.getRequestDispatcher("/View/Website/DetallTrans.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Oderdetall x:listoder){
            a= x.getProduct();
            int q = a.getQuanlity();
            a.setQuanlity(q+x.getQuanlity());
            new DaoProduct().update(a);
            new DaoOder().remove(x.getId());
        }
        new DaoTransaction().remove(transaction);
        resp.sendRedirect(req.getContextPath()+"/history");
    }
}
