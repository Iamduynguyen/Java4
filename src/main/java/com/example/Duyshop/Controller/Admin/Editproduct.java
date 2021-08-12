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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/admin/editproduct/*")
@javax.servlet.annotation.MultipartConfig
public class Editproduct extends HttpServlet {
    DaoProduct daoProduct = new DaoProduct();
    Product product = new Product();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                int id = Integer.parseInt(req.getParameter("id"));
                product = daoProduct.findbyId(id);
                System.out.println(product.toString());
                req.setAttribute("bean",product);
                DaoCatalog catalog = new DaoCatalog();
                req.setAttribute("lstcatalog",catalog.findall());
                req.getRequestDispatcher("/View/Admin/Editproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("dd/MM/yyyy");
            ConvertUtils.register(dtc, Date.class);
            BeanUtils.populate(product,req.getParameterMap());
            String realpath = req.getServletContext().getRealPath("/image");
            Catalog catalog = new DaoCatalog().findbyid(Integer.parseInt(req.getParameter("cataid")));
            if (req.getPart("img1")!=null){
                Help.writefile(req.getPart("img1"),realpath);
                product.setImg1(req.getPart("img1").getSubmittedFileName());
            }
            if (req.getPart("img2")!=null){
                Help.writefile(req.getPart("img2"),realpath);
                product.setImg2(req.getPart("img2").getSubmittedFileName());
            }
            if (req.getPart("img3")!=null){
                Help.writefile(req.getPart("img3"),realpath);
                product.setImg3(req.getPart("img3").getSubmittedFileName());
            }
            product.setCatalog(catalog);
            daoProduct.update(product);
            System.out.println(product.toString());
            resp.sendRedirect(req.getContextPath()+"/admin/product");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
