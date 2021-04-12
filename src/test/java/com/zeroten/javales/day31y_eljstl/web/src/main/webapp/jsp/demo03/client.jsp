<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/27
  Time: 下午3:07
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
    <title>client</title>
</head>
<body>
    <c:if test="${empty list}">
        当前数据为空
    </c:if>
    <c:if test="${!empty user}">
        <c.forEach items="${user}" var="user" varStatus="status">
            ${user.id}
            ${user.username}
                <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </c.forEach>
    </c:if>
    <c:if test="${!empty list}">
        <c:forEach items="${list}" var="person" varStatus="status">
            <div>
                <span>
                    ${status.index}
                </span>
                <span>
                    ${person.id}
                </span>
                <span>
                    ${person.name}
                </span>
                <span>
                    ${person.age}
                </span>

            </div>
        </c:forEach>
    </c:if>
</body>
</html>
