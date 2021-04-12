<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/25
  Time: 下午4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        // 全局声明
        public void test() {
            System.out.println("我是一个全局方法");
        }

    %>
   <%
       test();
   %>
</body>
</html>
