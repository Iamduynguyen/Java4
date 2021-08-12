package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.Customer;
import com.example.Duyshop.Mode.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class HistoryBouth extends HttpServlet {
    List<Transaction> lst = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("customer_id")==null){
            resp.sendRedirect(req.getContextPath()+"/signin?error=Chua dang nhap");
            return;
        }
        try {
            Customer customer = (Customer) req.getSession().getAttribute("customer_id");
            lst = new DaoTransaction().findbycustomer(customer);
            req.setAttribute("lst",lst);
            req.setAttribute("cus",customer);
            req.getRequestDispatcher("/View/Website/Historybought.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
