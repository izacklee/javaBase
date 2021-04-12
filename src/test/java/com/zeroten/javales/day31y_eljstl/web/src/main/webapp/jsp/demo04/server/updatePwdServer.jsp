<%@ page import="com.m.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/29
  Time: 上午10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="com.m.service.impl.*" %>
<%@ page language="java" import="com.m.entity.*" %>
<%@ page language="java" import="java.util.*"%>
<html>
<head>
    <title>updatePwdServer</title>
</head>
<body>
    <%
        // 设置编码格式
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        UserServiceImpl service = new UserServiceImpl();
        User user = new User();

        String uri = "../page/updatePwd.jsp";
        if (username != "") {
            user.setUsername(username);
            List<User> list = service.queryUser(user);
            if (list.size() > 0) {
                user.setPassword(repassword);
                int r = service.updateUser(user);
                if (r == 1) {
                    uri = "../page/login.jsp";
                    request.setAttribute("message", "<font color='green'>修改成功</font>");
                } else {
                    request.setAttribute("message", "<font color='red'>修改失败</font>");
                }
            } else {
                request.setAttribute("message", "<font color='red'>修改失败</font>");
            }
        }
        request.getRequestDispatcher(uri).forward(request, response);

    %>
</body>
</html>
