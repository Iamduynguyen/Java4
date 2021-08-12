package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoCustomer;
import com.example.Duyshop.Dao.DaoStaff;
import com.example.Duyshop.Mode.Customer;
import com.example.Duyshop.Mode.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class Signin extends HttpServlet {
    String uri =null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        req.getSession().setAttribute("staff_id",null);
        req.getSession().setAttribute("customer_id",null);
        req.setAttribute("messengeError",req.getParameter("error"));
        req.getRequestDispatcher("/View/Website/Signin.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        if (req.getParameter("checkadmin")!=null){
            DaoStaff daoStaff =new DaoStaff();
            for (Staff x: daoStaff.findall()){
                if (email.equals(x.getEmail())&&pass.equals(x.getPassword())&&x.getActive()){
                    System.out.println("id la:"+x.getId());
                    HttpSession session = req.getSession();
                    session.setAttribute("staff_id",x);
                    if (x.getRole()){
                        resp.sendRedirect(req.getContextPath()+"/admin/trangchu");
                    }else {
                        resp.sendRedirect(req.getContextPath()+"/admin/historytrans");
                    }
                    return;
                }
            }
        }else {
            DaoCustomer daoCustomer = new DaoCustomer();
            for (Customer x: daoCustomer.findall()){
                if (email.equals(x.getEmail())&&pass.equals(x.getPassword())){
                    resp.sendRedirect(req.getContextPath()+"/index");
                    System.out.println("id la:"+x.getId());
                    HttpSession session = req.getSession();
                    session.setAttribute("customer_id",x);
                    return;
                }
            }
        }

        req.setAttribute("messengeError","Đăng nhập thất bại");
        req.getRequestDispatcher("/View/Website/Signin.jsp").forward(req, resp);
    }


}
