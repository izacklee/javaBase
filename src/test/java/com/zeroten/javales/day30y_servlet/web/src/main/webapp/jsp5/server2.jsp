<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 下午11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*"%>
<html>
<head>
    <title>server2</title>
</head>
<body>
    <%
        Cookie[] cs = request.getCookies();
        for (Cookie c : cs) {
             out.println(c.getName() + "=" + c.getValue());
        }
    %>

</body>
</html>
