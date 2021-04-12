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
<html>
<head>
    <title>server</title>
</head>
<body>
<%
    // 设置编码格式
    request.setCharacterEncoding("UTF-8");

    // 对象
    Person p = new Person(1,"Zack",18);
//    p.setId(1);
//    p.setName("Zack");
//    p.setAge(18);
    // 把对象设置属性
    request.setAttribute("person", p);

    // 字符串
    request.setAttribute("message", "this is test message");

    // Map集合
    Map<String, Object> m = new HashMap<String, Object>();
    m.put("id", 2);
    m.put("name", "Zack");
    m.put("age", 19);
    request.setAttribute("result", m);

    // List集合
    List<String> list = new ArrayList<String>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("listMsg", list);


    // 转发
    request.getRequestDispatcher("client.jsp").forward(request, response);
%>
</body>
</html>
