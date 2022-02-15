package com.example.filter;

import com.example.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {

        } catch (Exception e) {

            throw new RuntimeException(e); //把异常抛给tomcat管理展示错误页面
        }
    }

    @Override
    public void destroy() {

    }
}
