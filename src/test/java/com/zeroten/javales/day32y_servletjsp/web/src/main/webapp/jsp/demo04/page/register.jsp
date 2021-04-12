<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/28
  Time: 上午12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" isELIgnored="false"%>
<%
    // 获取绝对路径的根路径
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
    request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>register</title>
</head>
<body>

    <div>
        <div>${message}</div>
        <form action="<%=basePath%>/jsp/demo04/server/createUserServer.jsp" method="POST">
            <table>
                <tr>
                    <td>用&nbsp;户&nbsp;名：<input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>重复密码：<input type="password" name="repassword"/></td>
                </tr>
                <tr>
                    <td>真实姓名：<input type="text" name="real_name"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="注册"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
