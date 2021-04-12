<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2021/3/11
  Time: 下午5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/t3/upload.do" method="POST" enctype="multipart/form-data">
        <input type="file" name="upload" />
        <input type="submit" value="upload" />
    </form>

</body>
</html>
