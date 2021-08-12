package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoCustomer;
import com.example.Duyshop.Help.Help;
import com.example.Duyshop.Mode.Customer;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/myaccount")
@MultipartConfig
public class InforCustomer extends HttpServlet {
    Customer customer = new Customer();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("customer_id")!=null) {
            customer = (Customer) session.getAttribute("customer_id");
            req.setAttribute("cus",customer);
        }else {
            resp.sendRedirect(req.getContextPath()+"/signin");
        }
        req.setAttribute("bean",customer);
        req.getRequestDispatcher("/View/Website/CustomerInfor.jsp").forward(req,resp);
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
            BeanUtils.populate(customer,req.getParameterMap());
            if (req.getPart("images")!=null){
                Help.writefile(req.getPart("images"),realpath);
                customer.setImage(req.getPart("images").getSubmittedFileName());
            }
            if (req.getParameter("checksetpass")!=null){
                if (customer.getPassword().equals(req.getParameter("opass"))){
                    if (!req.getParameter("repass").equals(req.getParameter("newpass"))){
                        resp.sendRedirect(req.getContextPath()+"/myaccount?error=Mật khẩu mới k khớp");
                    }
                    customer.setPassword(req.getParameter("newpass"));
                }else {
                    resp.sendRedirect(req.getContextPath()+"/myaccount?error=Mật khẩu cũ sai");
                }
            }
            resp.sendRedirect(req.getContextPath()+"/myaccount?success=xong");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
