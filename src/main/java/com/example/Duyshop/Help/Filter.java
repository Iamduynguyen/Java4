package com.example.Duyshop.Help;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Filter extends javax.servlet.Filter {
    @Override
    default void init(FilterConfig filterConfig) throws ServletException {
        javax.servlet.Filter.super.init(filterConfig);
    }

    @Override
    default void destroy() {
        javax.servlet.Filter.super.destroy();
    }

    @Override
    default void doFilter(ServletRequest req, ServletResponse reps, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) reps;
        this.doFilter(request,response,chain);
    }

    void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException;
}
