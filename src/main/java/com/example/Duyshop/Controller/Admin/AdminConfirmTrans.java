package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/confirmtrans")
public class AdminConfirmTrans extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Transaction> lsttrans = new DaoTransaction().findbystatus(2);
        req.setAttribute("lsttrans",lsttrans);
        req.getRequestDispatcher("/View/Admin/ConfirmTracsaction.jsp").forward(req, resp);
    }
}
