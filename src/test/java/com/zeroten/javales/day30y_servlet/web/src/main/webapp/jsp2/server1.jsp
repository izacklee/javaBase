<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 上午9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*"%>
<html>
<head>
    <title>server1</title>
</head>
<body>
<%
    // 在参数请求前
    // 指定编码格式 编码格式默认IS0-8859-1
    // 只对POST起作用，在tomcat配置文件server.xml加useBodyEncodingForURI="true"后，GET才起作用
    request.setCharacterEncoding("UTF-8");

    // 获取请求的参数，获取到的所有数据都是String类型
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    session.setAttribute("username", username);
    session.setAttribute("password", password);
%>
<%=username %>
<%=password %>
</body>
</html>
