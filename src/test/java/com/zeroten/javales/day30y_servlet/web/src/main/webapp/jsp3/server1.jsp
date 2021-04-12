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
        // application作用于所有会话 所有属性 整个服务器共享
        Integer num = (Integer) application.getAttribute("num");
        if (num == null) {
            num = 1;
        } else {
            num += 1;
        }
        application.setAttribute("num", num);
    %>
    <%="当前访问人数：" + num %>
</div>
</body>
</html>
