<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/27
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.m.entity.*" %>
<%@ page language="java" isELIgnored="false" %>
<html>
<head>
    <title>server</title>
</head>
<body>
<%
    // 设置编码格式
    request.setCharacterEncoding("UTF-8");

    User u =new User();
    u.setId(1);
    u.setUsername("Zack");
    u.setCreateTime(new Date());
    request.setAttribute("user",u);

    List<Person> l = new ArrayList<Person>();
    l.add(new Person(1, "Zack",18));
    l.add(new Person(2, "Zack",19));
    l.add(new Person(3, "Zack",20));
    request.setAttribute("list", l);
    // 转发
    request.getRequestDispatcher("client.jsp").forward(request, response);
%>

</body>
</html>
