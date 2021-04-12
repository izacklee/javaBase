<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/25
  Time: 下午4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="com.m.entity.Person"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=
        new Date()
    %>
    <%= new Person()%>
</body>
</html>
