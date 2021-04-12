<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 下午6:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
    <title>server3</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        // 获取
//        String newUsername = (String) request.getAttribute("newUsername");
        Date serverDate = (Date) request.getAttribute("serverDate");

        // 重定向只可能携带参数，没有属性
        String newUsername = request.getParameter("newUsername");
    %>
<%--        <%=username %>--%>
        <%=newUsername %>
        <%=serverDate %>
</body>
</html>
