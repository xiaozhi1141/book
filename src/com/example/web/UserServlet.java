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
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if(userService.login(user) == null){
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }
    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        User user =  WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //验证码写死abcd
        //equalsIgnoreCase忽略大小写
        if("abcd".equalsIgnoreCase(code)){
            if(userService.existsUsername(user.getUsername())){
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else{
                userService.registUser(user);
                System.out.println();
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        } else{
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
