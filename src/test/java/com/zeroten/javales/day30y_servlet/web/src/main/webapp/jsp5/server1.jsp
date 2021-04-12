<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 下午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
    <title>server1</title>
</head>
<body>
    <%
        Cookie c1 = new Cookie("key1","value1");
        c1.setMaxAge(6000); // 设置最大有效时间
        Cookie c2 = new Cookie("key2", "value2");
        c2.setMaxAge(6000);
        response.addCookie(c1);
        response.addCookie(c2);
    %>
</body>
</html>
