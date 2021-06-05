<%--
  Created by IntelliJ IDEA.
  User: 23108
  Date: 2021/5/10
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://"+ request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<base href=<%=basePath%>>
<!--	写base标签永远固定相对路径跳转的结果     -->
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<style>
    a{
        text-decoration:none;
    }
</style>