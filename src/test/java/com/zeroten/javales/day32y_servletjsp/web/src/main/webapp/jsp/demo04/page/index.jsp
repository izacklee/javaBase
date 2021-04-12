<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/29
  Time: 上午12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" isELIgnored="false" %>
<%--核心标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--国际化/标准标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <c:if test="${empty user}">
        <div>登录失败，请重新登录</div>
    </c:if>

    <c:if test="${!empty user}">
        <div>欢迎${user.username}用户</div>
    </c:if>
</body>
</html>
