<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/5/12
  Time: 下午6:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isELIgnored="false" %>
<html>
<head>
    <c:if test="${empty books}">
        <title>insert</title>
    </c:if>
    <c:if test="${!empty books}">
        <title>post</title>
    </c:if>
    <style>
        table {
            width: 100%;
        }
        table td {
            border: 1px solid #000;
        }
    </style>
</head>
<body>
    <form action="/books/save.do" method="post">
        <input type="hidden" name="id" value="${books.id}" />
        <table>
            <tr>
                <td>书名：</td>
                <td>
                    <input type="text" name="name" value="${books ne null ? books.name : ''}"/>
                </td>
            </tr>
            <tr>
                <td>作者：</td>
                <td>
                    <input type="text" name="author" value="${books ne null ? books.author : ''}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
