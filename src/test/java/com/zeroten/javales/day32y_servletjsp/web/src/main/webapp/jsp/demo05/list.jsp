<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/5/3
  Time: 下午12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <ul>
<%--            <li>${list[0]}</li>--%>
<%--            <li>${list[1]}</li>--%>
<%--            <li>${list[2]}</li>--%>
            <c:if test="${!empty list}">
                <c:forEach items="${list}" var="item" varStatus="status">
                     <li>${status.index} ${item}</li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</body>
</html>
