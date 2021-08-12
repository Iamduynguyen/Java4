package com.example.Duyshop.Controller.Website;


import com.example.Duyshop.Dao.DaoFavourite;
import com.example.Duyshop.Mode.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myproduct")
public class MyProduct extends HttpServlet {
    Customer customer= new Customer();
    DaoFavourite dao =new DaoFavourite();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("customer_id")==null){
            resp.sendRedirect(req.getContextPath()+"/signin");
            return;
        }
           customer = (Customer) req.getSession().getAttribute("customer_id");
           req.setAttribute("cus",customer);
           req.setAttribute("lstlike",dao.findlikebycus(customer.getId()));
            req.setAttribute("lstsold",dao.findsoldbycus(customer.getId()));
           req.getRequestDispatcher("/View/Website/Myproduct.jsp").forward(req,resp);
    }
}
