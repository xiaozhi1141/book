<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%@ include file="/pages/common/head.jsp"%></head>
<style>
    a{
        text-decoration:none;
    }
</style>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg" >
    <span class="wel_word">订单详情</span>
    <%@ include file="/pages/common/login_sucess_menu.jsp"%>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>订单号</td>
        </tr>
            <c:forEach items="${requestScope.orderItems}" var="entry">
                <tr>
                    <td>${entry.name}</td>
                    <td>${entry.count}</td>
                    <td>${entry.price}</td>
                    <td>${entry.totalPrice}</td>
                    <td>${entry.orderId}</td>
                </tr>
            </c:forEach>
    </table>
    <%--		如果购物车非空才输出下面的内容--%>
<%--    <c:if test="${not empty sessionScope.cart.items}">--%>
<%--        <div class="cart_info">--%>
<%--            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>--%>
<%--            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>--%>
<%--            <span class="cart_span"><a id="clearCart" href="carServlet?action=clear">清空购物车</a></span>--%>
<%--            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>--%>
<%--        </div>--%>
<%--    </c:if>--%>

</div>

<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
