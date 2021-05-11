package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //验证码写死abcd
        //equalsIgnoreCase忽略大小写
        if("abcd".equalsIgnoreCase(code)){
            if(userService.existsUsername(username)){
                request.setAttribute("msg","用户名已存在！");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist.jsp");
                requestDispatcher.forward(request,response);
            } else{
                userService.registUser(new User(null,username,password,email));
                System.out.println();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist_success.jsp");
                requestDispatcher.forward(request,response);
            }

        } else{
            request.setAttribute("msg","验证码错误！");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
