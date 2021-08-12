package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoOder;
import com.example.Duyshop.Dao.DaoStaff;
import com.example.Duyshop.Dao.DaoTransaction;
import com.example.Duyshop.Mode.Customer;
import com.example.Duyshop.Mode.Oderdetall;
import com.example.Duyshop.Mode.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/mycart")
public class mycart extends HttpServlet {
    Transaction transaction = new Transaction();
    List<Transaction> lst = new ArrayList<>();
    Customer customer = new Customer();
    DaoTransaction daoTransaction = new DaoTransaction();
    DaoOder daoOder = new DaoOder();
    List<Oderdetall> lstoder = new ArrayList<>();
    Oderdetall oderdetall = new Oderdetall();
    int sale=0;
    int idoder;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("customer_id")!=null){
            customer = (Customer) session.getAttribute("customer_id");
            System.out.println(customer.getName());
            lst = daoTransaction.findbyCustomer(customer.getId());
            transaction = daoTransaction.findbyCustomer(customer.getId(),1);
        }else {
            resp.sendRedirect(req.getContextPath()+"/signin");
            return;
        }
        if (req.getParameter("id_oder")!=null){
            idoder = Integer.parseInt(req.getParameter("id_oder"));
        }else {
            idoder=-1;
        }
        if (idoder>0){
            daoOder.remove(idoder);
        }
        if (req.getParameter("error")!=null){
            req.setAttribute("error",req.getParameter("error"));
        }
        lstoder = daoOder.findbyTransaction(transaction.getId());
        req.setAttribute("cus",customer);
        req.setAttribute("customer",customer);
        req.setAttribute("sale",sale);
        req.setAttribute("amounttotal",transaction.getAmouttotal()-sale);
        req.setAttribute("temp",transaction.getAmouttotal());
        req.setAttribute("lstoder",lstoder);
        req.setAttribute("tranID",transaction.getId());
        req.getRequestDispatcher("/View/Website/Mycart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (transaction.getAmouttotal()==0){
            resp.sendRedirect(req.getContextPath()+"/transaction?error=Bạn đã mua gì đâu");
        }
        req.setAttribute("cus",customer);
        transaction.setCreated(new Date());
        transaction.setStatus(2);
        transaction.setCustomerName(customer.getName());
        transaction.setCustomerAddress(customer.getAddress());
        transaction.setCustomerPhone(customer.getPhone());
        transaction.setAmouttotal(transaction.getAmouttotal()-sale);
        daoTransaction.update(transaction);
        Transaction newtrans = new Transaction();
        newtrans.setCustomer(customer);
        newtrans.setStaff(new DaoStaff().findbyId(1));
        newtrans.setCreated(new Date());
        newtrans.setStatus(1);
        daoTransaction.create(newtrans);
        resp.sendRedirect(req.getContextPath()+"/");
    }
}
