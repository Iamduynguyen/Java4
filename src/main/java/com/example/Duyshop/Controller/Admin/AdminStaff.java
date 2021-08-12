package com.example.Duyshop.Controller.Admin;

import com.example.Duyshop.Dao.DaoStaff;
import com.example.Duyshop.Mode.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/staff")
public class AdminStaff extends HttpServlet {
    List<Staff> lststaffactive;
    List<Staff> lststaffnoactive;
    int id = -1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lststaffactive = new DaoStaff().findactive(true);
        lststaffnoactive = new DaoStaff().findactive(false);
        Staff staff = (Staff) req.getSession().getAttribute("staff_id");
        if (staff.getRole()==false){
            resp.sendRedirect(req.getContextPath()+"/admin/historytrans");
        }
        if (req.getParameter("lock")!=null){
            int id = Integer.parseInt(req.getParameter("lock"));
            for (Staff x:lststaffactive){
                if (x.getId()==id){
                    staff =x;
                    break;
                }
            }
            staff.setActive(false);
            new DaoStaff().update(staff);
        }
        if (req.getParameter("active")!=null){
            int id = Integer.parseInt(req.getParameter("active"));
            for (Staff x:lststaffnoactive){
                if (x.getId()==id){
                    staff =x;
                    break;
                }
            }
            staff.setActive(true);
            new DaoStaff().update(staff);
        }
        lststaffactive = new DaoStaff().findactive(true);
        lststaffnoactive = new DaoStaff().findactive(false);
        req.setAttribute("lstno",lststaffnoactive);
        req.setAttribute("lststaff",lststaffactive);
        req.getRequestDispatcher("/View/Admin/AdminStaff.jsp").forward(req,resp);
    }
}
