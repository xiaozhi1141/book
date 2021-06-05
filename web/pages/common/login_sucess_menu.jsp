<%--
  Created by IntelliJ IDEA.
  User: 23108
  Date: 2021/5/10
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
    <a href="orderServlet?action=showMyOrders">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>

