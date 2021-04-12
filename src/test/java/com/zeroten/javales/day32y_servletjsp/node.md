#### 1.Servlet：
   （1）为什要使用Servlet? jsp的初衷是为了能够更方便的进行视图展示的
   （2）改善jsp的运行和开发模式：jsp只负责数据的展示，servlet负责业务逻辑的处理
   （3）MVC：
        3.1）模型层M：操作数据
            3.1.1）service
            3.1.2）dao
                3.1.2.1）entity
                3.1.2.2）vo（对entity的扩展）
            3.1.3）DB
        3.2）视图层V：展示数据
        3.3）交互层C：数据传递
   （4）Servlet的三种创建方式：
        4.1）实现Servlet接口
        4.2）继承GenericServlet类
        4.3）继承HttpServlet类
   （5）Servlet的生命周期
        5.1）加载和实例化：只加载和实例化一次，由容器负责加载，在请求抵达时实例化
        5.2）初始化：只会初始化一次，实例化完后初始化
        5.3）处理请求：每次请求抵达后，都会触发业务逻辑处理
        5.4）销毁：容器关闭，或者servlet被收回触发
   （6）配置web.xml
        6.1）配置servlet
        6.2）servlet和servlet-mapping两个标签是一对
        6.3）每一对是servlet-name必须一致
        6.4）url-pattern的配置方式：
            6.4.1）使用绝对路径 如：/demo/test1.do
            6.4.2）指定前缀 如：/test/*
            6.4.3）使用通配符指定后缀 如：*.do  
   （7）servlet应用
        7.1）获取web.xml当中的数据
        7.2）获取application
        7.3）获取session
        7.4）获取request 
        7.5）获取response   
   （8）简单的请求分发
   （9）转发jsp
   （10）ajax请求
   （11）征集一套前端页面
        10.1）云盘
        10.2）有个人中心
        10.3）有云盘操作
        10.4）有后台
        
        Servlet3.0的web.xml配置基本框架：
        <?xml version="1.0" encoding="UTF-8"?>
        <web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
            http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" >
            
        </web-app>         
            