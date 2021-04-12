<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 上午9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>server1</title>
</head>
<body>
<div>
    <%
        pageContext.setAttribute("test","Zack");
    %>
     <%=pageContext.getAttribute("test") %>
</div>
</body>
</html>
