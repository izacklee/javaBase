<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%--解决EL表达式不解析 设置isELIgnored是否忽略EL表达式为false--%>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
${message}
</body>
</html>