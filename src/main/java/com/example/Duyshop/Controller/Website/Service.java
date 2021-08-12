package com.example.Duyshop.Controller.Website;



import com.example.Duyshop.Dao.DaoProduct;
import com.example.Duyshop.Mode.Customer;
import com.example.Duyshop.Mode.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/service")
public class Service extends HttpServlet {
    DaoProduct daoProduct = new DaoProduct();
    List<Product> allPro = new ArrayList<>();
    List<Product> fashionlst = new ArrayList<>();
    List<Product> diamondlst = new ArrayList<>();
    List<Product> sportlst = new ArrayList<>();
    int page = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("page")!=null){
                page = Integer.parseInt(req.getParameter("page"));
            }else {
                page =1;
            }
            if (req.getSession().getAttribute("customer_id")!=null){
                Customer customer = (Customer) req.getSession().getAttribute("customer_id");
                req.setAttribute("cus",customer);
            }
            allPro = daoProduct.findbycataidlimit(-1,page,6);
            fashionlst = daoProduct.findbycataidlimit(1,page,6);
            diamondlst = daoProduct.findbycataidlimit(2,page,6);
            sportlst = daoProduct.findbycataidlimit(3,page,6);
            req.setAttribute("fashionlst",fashionlst);
            req.setAttribute("diamondlst",diamondlst);
            req.setAttribute("sportlst",sportlst);
            req.getRequestDispatcher("/View/Website/Service.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
