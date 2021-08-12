package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoFavourite;
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

@WebServlet("/admin/infortrans")
public class AdminInforTrans extends HttpServlet {
    Transaction transaction = new Transaction();
    List<Oderdetall> listoder = new ArrayList<>();
    ProductCustomer procus = new ProductCustomer();
    Product a = new Product();
    Customer cus = new Customer();
    int id = -1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        transaction = new DaoTransaction().findbyId(id);
        listoder = transaction.getLstOder();
        req.setAttribute("trans",transaction);
        req.setAttribute("lst",listoder);
        req.getRequestDispatcher("/View/Admin/AdminInforTrans.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Staff staff = (Staff) req.getSession().getAttribute("staff_id");
        if (req.getParameter("confirm").equals("yes")){
            transaction.setStaff(staff);
            transaction.setStatus(3);
            for (Oderdetall x:listoder){
                a =x.getProduct();
                cus = transaction.getCustomer();
                if (new DaoFavourite().Findlikebycustomer(cus.getId(),a.getId())!=null){
                    procus = new DaoFavourite().Findlikebycustomer(cus.getId(),a.getId());
                    procus.setSold(true);
                    new DaoFavourite().update(procus);
                }else {
                    procus.setProduct(x.getProduct());
                    procus.setCustomer(cus);
                    procus.setLike(false);
                    procus.setSold(true);
                    new DaoFavourite().create(procus);
                }
                System.out.println(procus.getCustomer().getName());
                a.setSold(a.getSold()+1);
                new DaoProduct().update(a);
            }
            new DaoTransaction().update(transaction);
        }else {
            for (Oderdetall x:listoder){
                a= x.getProduct();
                int q = a.getQuanlity();
                a.setQuanlity(q+x.getQuanlity());
                new DaoProduct().update(a);
                new DaoOder().remove(x.getId());
            }
            new DaoTransaction().remove(transaction);
        }
        resp.sendRedirect(req.getContextPath()+"/admin/historytrans");
    }
}
