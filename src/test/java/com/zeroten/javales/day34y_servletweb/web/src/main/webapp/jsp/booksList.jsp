<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/5/10
  Time: 下午8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>booksList</title>
    <style>
        table {
            width: 100%;
        }
        table td {
            border: 1px solid #000000;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td colspan="5">
                <a href="/books/insert.do">创建</a>
            </td>
        </tr>
        <tr>
            <td>序号</td>
            <td>书名</td>
            <td>作者</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <c:if test="${!empty booksList}">
            <c:forEach items="${booksList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.name}</td>
                <td>${item.author}</td>
                <td>${item.createTime}</td>
                <td>
                    <a href="/books/update.do?id=${item.id}">编辑</a>
                    |
                    <a href="/books/delete.do?id=${item.id}">删除</a>
                </td>
            </tr>
            </c:forEach>
        </c:if>
        <tr>
            <td colspan="5">
                <a href="/books/list.do?pageNumber=1">首页</a>

                <a href="/books/list.do?pageNumber=${(page.pageNumber - 1 < 1)
                ? 1 : page.pageNumber - 1}">上一页</a>

                <span>当前${page.pageNumber}页/总${page.pageCount}页/总${page.count}条</span>

                <a href="/books/list.do?pageNumber=${page.pageNumber + 1 ge page.pageCount
                ? page.pageCount : page.pageNumber + 1}">下一页</a>

                <a href="/books/list.do?pageNumber=${page.pageCount}">尾页</a>
            </td>
        </tr>
    </table>
</body>
</html>
