package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.Staff;
import com.example.Duyshop.Mode.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/historytrans")
public class HistoryTrans extends HttpServlet {
    List<Transaction> lst =  new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Staff staff = (Staff) req.getSession().getAttribute("staff_id");
        if (staff.getRole()){
            lst = new DaoTransaction().findbystatus(3);
        }else {
            lst = new DaoTransaction().findbystatusandstaff(3,staff);
        }
        req.setAttribute("lst",lst);
        req.getRequestDispatcher("/View/Admin/HistoryTrans.jsp").forward(req,resp);
    }
}
