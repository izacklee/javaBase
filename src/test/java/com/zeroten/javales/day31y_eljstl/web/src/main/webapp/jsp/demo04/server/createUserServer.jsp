<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 下午9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" isELIgnored="false" %>
<%@ page language="java" import="com.m.service.*"%>
<%@ page language="java" import="com.m.service.impl.*"%>
<%@ page import="com.m.entity.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>createUserServer</title>
</head>
<body>
    <%
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        UserService service = new UserServiceImpl();
        User u = new User();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String realName = request.getParameter("real_name");

        String uri = "../page/register.jsp";
        if (username != "") {
            u.setUsername(username);
            List<User> users = service.queryUser(u);

            if (users.size() == 0) {
                u.setPassword(password);
                u.setRealName(realName);
                int row = service.insertUser(u);
                if (row == 1) {
                    request.setAttribute("message","<font color='green'>注册成功</font>");
                    uri = "../page/login.jsp";
                } else {
                    request.setAttribute("message","<font color='red'>注册失败</font>");
                }
             } else {
                request.setAttribute("message","<font color='red'>注册失败</font>");
            }
        }
        request.getRequestDispatcher(uri).forward(request,response);
    %>
</body>
</html>
