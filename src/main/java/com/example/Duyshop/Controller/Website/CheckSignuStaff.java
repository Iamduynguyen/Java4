package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoCustomer;
import com.example.Duyshop.Dao.DaoStaff;
import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.Customer;
import com.example.Duyshop.Mode.Staff;
import com.example.Duyshop.Mode.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/signup/check")
public class CheckSignuStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/Website/Checksignup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        System.out.println(code);
        String mailcode = req.getParameter("check");
        if (req.getParameter("who").equals("staff")){
            if (code.equals(mailcode)){
                DaoStaff daoStaff =new DaoStaff();
                Staff staff = (Staff) session.getAttribute("staff");
                System.out.println(staff.toString());
                staff.setActive(false);
                daoStaff.create(staff);
                session.setAttribute("success","Hãy chờ quản trị viên xác nhận");
            }else {
                System.out.println("cc");
                req.setAttribute("messengeError","Sai mã xác nhận");
            }
        }else {
            if (code.equals(mailcode)){
                DaoCustomer daoCustomer = new DaoCustomer();
                Customer customer = (Customer) session.getAttribute("customer");
                System.out.println(customer.toString());
                if (daoCustomer.create(customer)){
                    session.setAttribute("success","Đã tạo thành công");
                }
            }else {
                System.out.println("cc");
                req.setAttribute("messengeError","Sai mã xác nhận");
            }
        }
        req.getRequestDispatcher("/View/Website/Checksignup.jsp").forward(req, resp);
    }
}
