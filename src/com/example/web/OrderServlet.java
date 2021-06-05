package com.example.web;

import com.example.pojo.Cart;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.User;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import com.example.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取用户Id;
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser == null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
        //生成订单
        String orderId = orderService.createOrder(cart, userId);
        req.getSession().setAttribute("orderId",orderId);
//        req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    /**
     * 查看所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("pages/manager/order_manager.jsp").forward(req,resp);
    }

    /**
     * 发货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 查看订单详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("pages/order/order_items.jsp").forward(req,resp);
    }

    /**
     * 查看我的订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser == null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
        List<Order> orders = orderService.showMyOrders(userId);
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("pages/order/order.jsp").forward(req,resp);
    }

    /**
     * 签收
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiverOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
