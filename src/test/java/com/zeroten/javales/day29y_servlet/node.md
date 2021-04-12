#### 1.Servlet
   （1）学好Servlet，有助于今后我们更好的学习交互层框架的应用，以及有助于我们真正掌握WEB开发的业务设计。
    不要把自己学成一个配置员，比如会多少个框架，却把底层的东西给忘了。把底层学扎实了，学框架只要搞懂把原本
    底层复杂的业务逻辑替换成框架的用法就够了。
   （2）JSP：这是J2EE非常重要的一个部分
   （3）URL的组成：
        3.1）协议头
        3.2）主机地址
        3.3）目标资源地址
        3.4）参数
   （4）Tomcat 
        1）web应用服务器，轻量级，开源的（免费）
            下载7.0.103版，地址：https://tomcat.apache.org/download-70.cgi
            MAC开启tomcat：sudo /usr/local/tomcat/bin/startup.sh
                关闭tomcat:sudo /usr/local/tomcat/bin/shutdown.sh
            windows是执行startup.bat/shutdown.bat开启/关闭   
        2）可以配置管理员，但是不建议配置，以防被别人破解黑站
            配置文件地址：/usr/local/tomcat/conf/tomcat-users.xml
        3）netcat：可实现端口转发，所以端口的暴露是很危险了，一般只保留80端口，其他端口禁止掉
        4）配置端口：
            4.1）端口可自行配置
            4.2）80端口访问不需要加端口号，直接输入主机地址即可访问        
            配置文件地址：/usr/local/tomcat/conf/server.xml
        5）什么是web的资源？web的资源都是要通过浏览器下载到本地再执行的
        6）web的根目录是webapp
        7）直接访问地址：
            静态资源下载 
            web的请求
    （5）JSP（Java Server Pages）最大的优势就是安全（需要内部转码，重新编码）
        5.1）是在html中嵌套java代码，创建动态网页的。
            JSP就是java代码，用java代码写的。
            html不能直接访问服务器，所以要嵌套java代码。
        5.2）客户端访问jsp的流程：客户端(用户)访问jsp->编译jsp生成jsp.class->通过out输出流输出到浏览器->浏览器将其文件下来到本地->渲染给用户       
        5.3）<%@ include %>是编译时包含，<jsp:include >(<jsp:include page="jsp2.jsp" />)是运行时包含。
             前者就相当于宏，编译时替代，后者相当于函数，运行时返回。<% @ page %> 只能包含静态内容。 
        5.4）修改jsp代码，不需要重启服务
        5.5）局部声明和全局声明
            a.局部声明生成在_jspService方法里
            b.全局声明生成在class类中
        5.6）Http状态码
            a.404：资源未找到
            b.500：请求的资源发生异常
            3.无法访问：服务没开 
        5.7）时间
            a.js是前端时间
            b.服务器时间是tomcat服务器提供的时间
            c. 引入包文件说明
                <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>             
                page：引入包文件
                contentType：响应头，在客户端在响应的时候，以什么样的编码格式输出
                pageEncoding：页面编码
        
   浏览器是解析html的容器，解析完之后进行渲染。