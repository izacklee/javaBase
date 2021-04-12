<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/28
  Time: 下午1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="com.m.service.impl.*" %>
<%@ page language="java" import="com.m.entity.*" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
    <title>loginServer</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserServiceImpl service = new UserServiceImpl();
        String uri = "../page/login.jsp";

        if (username != "" && password != "") {
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            List<User> users = service.queryUser(u);
            if (users.size() == 0) {
                request.setAttribute("message","<font color='red'>登录失败</font>");
            } else {
                uri = "../page/index.jsp";
                session.setAttribute("user",users.get(0));
            }
        }
        request.getRequestDispatcher(uri).forward(request,response);
    %>
</body>
</html>
