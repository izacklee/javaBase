<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2021/3/11
  Time: 下午6:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $.get("/t3/json1.do", function(data) {
            console.log(data)
            eval("data=" + data)  // 将String转换为jsonObject
            console.log(data) // 输出直接就是json格式了
        })
    });
</script>
<body>

</body>
</html>
