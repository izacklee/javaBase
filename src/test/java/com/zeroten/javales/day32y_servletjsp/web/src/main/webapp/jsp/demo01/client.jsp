<%--
  Created by IntelliJ IDEA.
  User: app
  Date: 2020/4/27
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.m.entity.*" %>
<%--解决EL表达式不解析 设置isELIgnored是否忽略EL表达式为false--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>client</title>

<%--    js中的用法--%>
    <!-- 这种引入js的方式不可用 -->
    <script text="text/javascript" src="/js/demo01.js"></script>
    <script>
        // 不能有两个window.onload
        // window.onload = function() {
            var msg = "${message}";
            console.log(msg+" jsp内用法");  // this is test message jsp内用法
        // }
    </script>
</head>
<body>
  <!--
    <div>
        <%=((Person) request.getAttribute("person")).getId() %>
    </div>
    <div>
        <%= ((Person) request.getAttribute("person")).getName() %>
    </div>
    <div>
        <%= ((Person) request.getAttribute("person")).getAge() %>
    </div>
    -->
<%--    对象--%>
    <div>用户id：${person.id}</div>
    <div>用户id：${person["id"]}</div>
    <div>用户姓名：${person.name}</div>
    <div>用户年龄：${person.age}</div>
    <div>用户对象：${person}</div>
    <br/>
    <br/>

<%--    字符串--%>
    <div>消息：${message}</div>
    <br/>
    <br/>

<%--    Map集合--%>
    <div>用户id：${result.id}</div>
    <div>用户姓名：${result.name}</div>
    <div>用户年龄：${result.age}</div>
    <br/>
    <br/>

<%--    List集合--%>
    <div>${listMsg.get(0)}</div>
    <div>${listMsg.get(1)}</div>
    <div>${listMsg[2]}</div>
    <br/>
    <br/>

<%--    input的写法--%>
    <div>
        用户id：<input type="text" name="id" value="${person.id}" />
        用户姓名：<input type="text" name="name" value="${person.name}" />
        用户年龄：<input type="text" name="age" value="${person.age}" />
    </div>
    <br/>
    <br/>

<%--    select的写法--%>
    <select>
        <option>${listMsg.get(0)}</option>
        <option>${listMsg.get(1)}</option>
        <option>${listMsg.get(2)}</option>
    </select>
    <br/>
    <br/>

    <div>
<%--        相等--%>
        ${1 eq 1}
<%--        不等--%>
        ${1 ne 1}
<%--        错误写法 不解析--%>
        ${1} == ${1}
    </div>
    <br/>
     <br/>

<%--    验证属性是否存在--%>
    <div>这个对象存在${!empty person}</div>
    <div>这个对象不存在${empty person}</div>
</body>
</html>