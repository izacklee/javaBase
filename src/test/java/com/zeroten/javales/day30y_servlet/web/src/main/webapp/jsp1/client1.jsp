<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/26
  Time: 上午9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>client1</title>
</head>
<body>
<div>
    <form action="server1.jsp" method="POST">
        <div>
            用户名：<input type="text" name="username" />
        </div>
        <div>
            密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" />
        </div>
        <div>
            籍&nbsp;&nbsp;&nbsp;贯：<select name="nativePlace">
                                        <option value="-1">--请选择--</option>
                                        <option value="1">北京</option>
                                        <option value="2">山东</option>
                                        <option value="3">天津</option>
                                    </select>
        </div>
        <div>
                性&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" value="1" />男
                                        <input type="radio" name="sex" value="0" />女
        </div>
        <div>
            爱&nbsp;&nbsp;&nbsp;好：
            <input type="checkbox" value="1" name="hobby" />旅游
            <input type="checkbox" value="2" name="hobby" />爬山
            <input type="checkbox" value="3" name="hobby" />看书
            <input type="checkbox" value="4" name="hobby" />摄影
        </div>
        <div>
            备&nbsp;&nbsp;&nbsp;注：<textarea rows="3" cols="3" name="remark"></textarea>
        </div>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
