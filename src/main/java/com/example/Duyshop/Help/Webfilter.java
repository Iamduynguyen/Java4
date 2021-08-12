package com.example.Duyshop.Help;

import com.example.Duyshop.Mode.Staff;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class Webfilter implements Filter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        try {
            req.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            String uri = req.getRequestURI();
            String error = "";
            if (req.getSession().getAttribute("staff_id")==null){
                error = resp.encodeRedirectURL("Chua dang nhap");
            }
            if (!error.isEmpty()){
                req.getSession().setAttribute("uri",uri);
                resp.sendRedirect(req.getContextPath()+"/signin?error="+error);
            }else {
                chain.doFilter(req,resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
