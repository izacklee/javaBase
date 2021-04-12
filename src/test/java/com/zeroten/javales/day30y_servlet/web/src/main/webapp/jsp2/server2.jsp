<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 下午11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>server2</title>
</head>
<body>
    <%
        String id = session.getId();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
//        session.invalidate(); // 设置session失效，失效后一定会重新生成sessionId
        session.removeAttribute("password");
    %>
    <%=id %>
    <br/>
    <%=username %>
    <%=password %>
</body>
</html>
