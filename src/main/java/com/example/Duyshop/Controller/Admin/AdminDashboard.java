package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoCtrolwebsite;
import com.example.Duyshop.Dao.DaoCustomer;
import com.example.Duyshop.Dao.DaoProduct;
import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.Product;
import com.example.Duyshop.Mode.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/trangchu")
public class AdminDashboard extends HttpServlet {
    List<Product> lstview = new ArrayList<>();
    List<Product> lstsold = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Staff staff = (Staff) req.getSession().getAttribute("staff_id");
        if (staff.getRole()==false){
            resp.sendRedirect(req.getContextPath()+"/admin/historytrans");
        }
        req.setAttribute("view",new DaoCtrolwebsite().find().getView());
        lstview = new DaoProduct().viewtop5();
        lstsold = new DaoProduct().soldtop5();
        int trans = new DaoTransaction().findbystatus(3).size();
        int cus = new DaoCustomer().findall().size();
        int pro = new DaoProduct().findall().size();
        req.setAttribute("trans",trans);
        req.setAttribute("cus",cus);
        req.setAttribute("pro",pro);
        req.setAttribute("lstview",lstview);
        req.setAttribute("lstsold",lstsold);
        req.getRequestDispatcher("/View/Admin/Admin.jsp").forward(req,resp);
    }
}
