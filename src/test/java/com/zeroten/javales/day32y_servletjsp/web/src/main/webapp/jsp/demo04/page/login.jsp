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
    <title>login</title>
</head>
<body>
    <div>
        <div>${message}</div>
        <form action="<%=basePath %>/jsp/demo04/server/loginServer.jsp" method="POST">
            <table>
                <tr>
                    <td>用户名：<input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;码：<input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="登录"/>
                    </td>
                    <td>
                        <a href="<%=basePath %>/jsp/demo04/page/register.jsp">注册用户</a>
                    </td>
                    <td>
                        <a href="<%=basePath %>/jsp/demo04/page/updatePwd.jsp">修改密码</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
