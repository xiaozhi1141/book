package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if(userService.login(user) == null){
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else{
            //保存用户登陆之后的信息到Session域中
            req.getSession().setAttribute("user",userService.login(user));
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }
    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        User user =  WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //equalsIgnoreCase忽略大小写
        if(token != null && token.equalsIgnoreCase(code)){
            if(userService.existsUsername(user.getUsername())){
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else{
                userService.registUser(user);
                req.getSession().setAttribute("user",userService.login(user));
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
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数username
        String username = req.getParameter("username");
        //调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成为map对象
        Map<String,Object>  resultMap = new HashMap<String,Object>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);

    }

}
