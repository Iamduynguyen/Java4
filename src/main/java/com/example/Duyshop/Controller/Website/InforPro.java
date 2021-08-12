package com.example.Duyshop.Controller.Website;


import com.example.Duyshop.Dao.*;

import com.example.Duyshop.Mode.*;

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

@WebServlet("/infor/*")
public class InforPro extends HttpServlet {
    int id;
    Customer customer = new Customer();
    DaoProduct daoProduct = new DaoProduct();
    Product product = new Product();
    List<Product> lst =  new ArrayList<>();
    Oderdetall oderdetall = new Oderdetall();
    ProductCustomer favourite = new ProductCustomer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("like"));
        if (req.getParameter("id")!=null){
            id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("cus",customer);
        }
        boolean likes =false;
        HttpSession session = req.getSession();
        if (session.getAttribute("customer_id")!=null){
            customer = (Customer) session.getAttribute("customer_id");
            System.out.println(customer.getName()+customer.getEmail());
            if (new DaoTransaction().findbyId(customer.getId())==null){
                Transaction transaction = new Transaction();
                transaction.setCreated(new Date());
                transaction.setCustomer(customer);
                transaction.setStaff(new DaoStaff().findbyId(1));
                transaction.setStatus(1);
                new DaoTransaction().create(transaction);
            }
            favourite = new DaoFavourite().Findlikebycustomer(customer.getId(),id);
            if (favourite!=null){
                if (favourite.getLike()){
                    likes = true;
                }else {
                    likes = false;
                }
            }else {
                likes = false;
            }
            new DaoFavourite().update(favourite);
            System.out.println("cc");
        }else {
            if (req.getParameter("like")!=null){
                System.out.println("day");
                resp.sendRedirect(req.getContextPath()+"/signin?error=Moi ban dang nhap");
                return;
            }
        }
        DaoProduct daoProduct = new DaoProduct();
        product = daoProduct.findbyId(id);
        product.setView(product.getView()+1);
        daoProduct.update(product);
        lst = daoProduct.findbycataidlimit(product.getCatalog().getId(),1,10);
        if (req.getParameter("like")!=null){
            likes = Boolean.parseBoolean(req.getParameter("like"));
            System.out.println("vao day");
            favourite = new DaoFavourite().Findlikebycustomer(customer.getId(),id);
            if (favourite==null){
                System.out.println("tao ne");
                ProductCustomer x= new ProductCustomer();
                x.setCustomer(customer);
                x.setProduct(product);
                x.setLike(true);
                x.setSold(false);
                new DaoFavourite().create(x);
                likes = false;
            }else {
                System.out.println("co roi");
                if (likes){
                    favourite.setLike(true);
                    likes = true;
                }else {
                    favourite.setLike(false);
                    likes = false;
                }
                new DaoFavourite().update(favourite);
            }
        }
        req.setAttribute("like",likes);
        req.setAttribute("lstfilter",lst);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/View/Website/ProInfor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("cccc");
        if (customer!=null){
            System.out.println("day"+customer.getName());
            req.setAttribute("cus",customer);
        }else {
            System.out.println("cccc");
            resp.sendRedirect(req.getContextPath()+"/signin");
        }

        if (req.getParameter("number")!=null){
            int quanlity = Integer.parseInt(req.getParameter("number"));
            product.setQuanlity(product.getQuanlity()-quanlity);
            daoProduct.update(product);
            oderdetall.setAmout(product.getPrice()-product.getDiscount());
            oderdetall.setProduct(product);
            oderdetall.setQuanlity(quanlity);
            oderdetall.setAmout((product.getPrice())-product.getDiscount()*quanlity);
            System.out.println("id" + customer.getId()+ customer.getName());
            System.out.println(customer.getId());
            Transaction transaction = new DaoTransaction().findbyCustomer(customer.getId(),1);
            oderdetall.setTransaction(transaction);
            new DaoOder().create(oderdetall);
            transaction.setAmouttotal(transaction.getAmouttotal()+oderdetall.getAmout());
            new DaoTransaction().update(transaction);
        }
        lst = daoProduct.findbycataidlimit(product.getCatalog().getId(),1,6);
        req.setAttribute("lstfilter",lst);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/View/Website/ProInfor.jsp").forward(req,resp);
    }
}
