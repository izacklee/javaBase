<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/27
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" isELIgnored="false" %>
<html>
<head>
    <title>client</title>
</head>
<body>
    ${pageScope.username} <!-- 获取不到 因其作用域于当前jsp -->
    ${requestScope.username}
    ${sessionScope.username}
    ${applicationScope.username}
</body>
</html>
