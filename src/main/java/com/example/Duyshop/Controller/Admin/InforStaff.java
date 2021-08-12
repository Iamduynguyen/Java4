package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoStaff;
import com.example.Duyshop.Help.Help;
import com.example.Duyshop.Mode.Staff;
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

@WebServlet("/admin/inforstaff")
@MultipartConfig
public class InforStaff extends HttpServlet {
    Staff staff = new Staff();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        staff = (Staff) req.getSession().getAttribute("staff_id");
        if (req.getParameter("error")!=null){
            req.setAttribute("error",req.getParameter("error"));
        }
        if (req.getParameter("succes")!=null){
            req.setAttribute("succes",req.getParameter("succes"));
        }
        req.setAttribute("bean",staff);
        req.setAttribute("img",staff.getImage());
        req.getRequestDispatcher("/View/Admin/InforStaff.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            staff = (Staff) req.getSession().getAttribute("staff_id");
            req.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            String realpath = req.getServletContext().getRealPath("/image");
            staff.setPhone(req.getParameter("phone"));
            if (req.getPart("images")!=null){
                Help.writefile(req.getPart("images"),realpath);
                staff.setImage(req.getPart("images").getSubmittedFileName());
            }
            if (req.getParameter("checksetpass")!=null){
                if (!staff.getPassword().equals(req.getParameter("oldpass"))){
                    resp.sendRedirect(req.getContextPath()+"/admin/inforstaff?error=Sai mật khẩu cũ");
                    return;
                }else {
                    staff.setPassword(req.getParameter("oldpass"));
                }
            }
            System.out.println(realpath);
            new DaoStaff().update(staff);
            resp.sendRedirect(req.getContextPath()+"/admin/inforstaff?succes=xong");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
