package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoProduct;
import com.example.Duyshop.Mode.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/admin/product")
public class AdminProduct extends HttpServlet {
    List<Product> lstpro = new ArrayList<>();
    Product product = new Product();
    DaoProduct daoProduct = new DaoProduct();
    int index = 0;
    int cataId;
    int page;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        page =1;
        if (req.getParameter("cataId")!=null){
            cataId = Integer.parseInt(req.getParameter("cataId"));
        }else {
            cataId = -1;
        }
        if (req.getParameter("page")!=null){
            page = Integer.parseInt(req.getParameter("page"));
        }else {
            page =1;
        }
        if (cataId<0){
            lstpro = daoProduct.findlimit(page);
        }else {
            lstpro = daoProduct.findlimitBycata(cataId,page);
        }

        index = (page-1)*5 ;
        req.setAttribute("idcata",cataId);
        req.setAttribute("page",page);
        req.setAttribute("lstpro",lstpro);
        req.setAttribute("index",index);
        req.getRequestDispatcher("/View/Admin/Product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("proname")!=null){
            lstpro = daoProduct.findbyname(cataId,req.getParameter("proname"));
        }
        req.setAttribute("idcata",cataId);
        req.setAttribute("page",page);
        req.setAttribute("lstpro",lstpro);
        req.setAttribute("index",index);
        req.getRequestDispatcher("/View/Admin/Product.jsp").forward(req,resp);
    }
}
