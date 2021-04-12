<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 下午6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
    <title>server2</title>
</head>
<body>
    <%
        // 设置字符集
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        username+="添加新内容";
        // 处理后的数据，可以保存到request中
        request.setAttribute("newUsername", username);
        request.setAttribute("serverDate",new Date());

        // 获取
//        String newUsername = (String) request.getAttribute("newUsername");
//        Date serverDate = (Date) request.getAttribute("serverDate");

        // 转发
//        request.getRequestDispatcher("server3.jsp").forward(request, response);

        // 重定向
        response.sendRedirect("jsp1/server3.jsp" +username);
//        response.sendRedirect("https://www.baidu.com");

    %>
<%--    <%=newUsername %>--%>
<%--    <%=serverDate %>--%>
</body>
</html>
