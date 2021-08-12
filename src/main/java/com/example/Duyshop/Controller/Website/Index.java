package com.example.Duyshop.Controller.Website;


import com.example.Duyshop.Mode.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/index"})
public class Index extends HttpServlet {
    Customer customer = new Customer();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("customer_id")!=null){
                customer = (Customer) session.getAttribute("customer_id");
                System.out.println(customer.getName()+customer.getEmail());
                req.setAttribute("cus",customer);
            }
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
