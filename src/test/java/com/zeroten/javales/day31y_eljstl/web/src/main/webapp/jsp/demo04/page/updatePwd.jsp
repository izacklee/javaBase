<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/28
  Time: 下午1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%
     // 获取绝对路径的根路径
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
    request.getServerPort() + path;
%>
<html>
<head>
    <title>updatePwd</title>
</head>
<body>
    <div>
        <div>${message}</div>
        <form action="${basePath}/jsp/demo04/server/updatePwdServer.jsp" method="POST">
            <table>
                <tr>
                    <td>
                        用户名：<input type="text" name="username" />
                    </td>
                </tr>
                <tr>
                    <td>
                        原密码：<input type="password" name="password" />
                    </td>
                </tr>
                <tr>
                    <td>
                        新密码：<input type="password" name="repassword" />
                    </td>
                </tr>
                <tr colspan="2">
                    <td>
                        <input type="submit" value="修改">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
