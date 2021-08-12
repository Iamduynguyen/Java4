package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoCatalog;
import com.example.Duyshop.Dao.DaoProduct;
import com.example.Duyshop.Help.Help;
import com.example.Duyshop.Mode.Catalog;
import com.example.Duyshop.Mode.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/admin/newproduct")
@javax.servlet.annotation.MultipartConfig
public class Newproduct extends HttpServlet {
    DaoProduct daoProduct = new DaoProduct();
    Product product = new Product();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoCatalog catalog = new DaoCatalog();
        req.setAttribute("lstcatalog",catalog.findall());
        req.getRequestDispatcher("/View/Admin/Newproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            String realpath = req.getServletContext().getRealPath("/image");
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("dd/MM/yyyy");
            ConvertUtils.register(dtc, Date.class);
            BeanUtils.populate(product,req.getParameterMap());
            System.out.println(realpath);
            Help.writefile(req.getPart("img1"),realpath);
            Help.writefile(req.getPart("img2"),realpath);
            Help.writefile(req.getPart("img3"),realpath);
            Catalog catalog = new DaoCatalog().findbyid(Integer.parseInt(req.getParameter("cataid")));
            product.setImg1(req.getPart("img1").getSubmittedFileName());
            product.setImg2(req.getPart("img2").getSubmittedFileName());
            product.setImg3(req.getPart("img3").getSubmittedFileName());
            product.setCatalog(catalog);
            daoProduct.create(product);
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/admin/product");
    }
}
