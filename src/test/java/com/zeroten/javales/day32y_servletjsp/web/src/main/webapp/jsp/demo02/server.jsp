<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/27
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.m.entity.*" %>
<%@ page language="java" isELIgnored="false" %>
<html>
<head>
    <title>server</title>
</head>
<body>
<%
    // 设置编码格式
    request.setCharacterEncoding("UTF-8");

    pageContext.setAttribute("username","page-Zack");
    request.setAttribute("username","request-Zack");
    session.setAttribute("username","session-Zack");
    application.setAttribute("username","application-Zack");

    // 转发
//    request.getRequestDispatcher("client.jsp").forward(request, response);
%>
  ${pageScope.username}
</body>
</html>
