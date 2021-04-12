#### 1.过滤器
   （1）对数据和相应的功能，统一处理(比如：日志、加密)
   （2）创建一个过滤器
        2.1）实现Filter接口
        2.2）在web.xml当中注册该过滤器
   （3）过滤器的生命周期
        3.1）初始化：启动tomcat就被初始化，多个过滤器，按照web.xml注册的顺序
        3.2）过滤器：客户端请求时触发；过滤器拦截的顺序，也是按照web.xml注册的顺序，多个的话url符合条件(一样)只会调用第一个
            可以调用FilterChain的实体方法，doFilter完成链式调用，url不一样不会产生此类情况
            想要请求抵达servlet，必须完成链式调用
        3.3）销毁：关闭tomcat时被销毁
   （4）open session in view （早期Struts2为了配合hibernate三级缓存开发的一种技术）
        4.1）可以不比使用数据库连接池
        4.2）优势是提高查询效率
        4.3）劣势是高并发的时候导致数据库连接不够用 
   （5）filter和spring的拦截器功能类试，是包裹着交互层(controller/servlet)进行操作
        filter和spring拦截器的区别：
                                filter                                     spring(Interceptor)
        多个的执行顺序     根据filter mapping配置的先后顺序              按照配置的顺序，但是可以通过order控制顺序
        规范          在Servlet规范中定义的，是Servlet容器支持的         Spring容器内的，是Spring框架支持的
        使用范围                只能用于Web程序中                       既可以用于Web程序，也可以用于Application、Swing程序中
        深度                  Filter在只在Servlet前后起作用             拦截器能够深入到方法前后、异常抛出前后等
   （6）Aop（面相切面编程）是包裹着业务层(service)进行操作
#### 2.监听器
   今天讲了7种，实际有8种，HttpSessionActivationListener -- session对象中属性的钝化与活化，现在基本不用了   
   （1）Servlet的当中的三大域
        1对多的监听，彻底和代码解耦
        1.1）Application
            7.1.1）监听作用域本身
                7.1.1.1）启动容器时，就调用了application监听的contextInitialized方法
                7.1.1.2）容器关闭时，调用了application监听的contextDestroyed方法
                7.1.1.3）可以在监听当中获取application
                7.1.1.4）只在容器启动和关闭时各调用一次创建和销毁application的方法
            7.1.2）监听作用域的元素
                7.1.2.1）可以监听到当前作用域当中所有元素的增减和修改
                7.1.2.2）监听到修改元素的值是旧值
        1.2）Session
            7.2.1）监听作用域本身
                7.2.1.1）调用Session监听sessionCreated方法才执行，方法只执行一次
                7.2.1.2）销毁
                        a.容器关闭
                        b.手动销毁：session.invalidate();
                        c.时间到期
            7.2.2）监听作用域的元素
                7.2.2.1）可以监听到当前作用域当中所有元素的增减和修改
                7.2.2.2）监听到修改元素的值是旧值
        1.3）Request
            7.3.1）监听作用域本身
                7.3.1.1）每次请求抵达时先触发requestInitialized方法，再触发requestDestroyed方法
                7.3.1.2）请求结束，立刻销毁
            7.3.2）监听作用域的元素
                7.3.2.1）可以监听到当前作用域当中所有元素的增减和修改
                7.3.2.2）监听到修改元素的值是当前值
  （2）创建监听
        2.1）实现监听的接口
        2.2）在web.xml注册监听   
  （3）监听绑定 
        3.1）当把监听加入session后，才会触发绑定的valueBound方法
            HttpSession session = hreq.getSession();  
            session.setAttribute("sessionListener",new BaseBindingListener());
        3.2）当session中，修改或删除该监听时触发解绑的valueUnbound方法   
        3.3）优点，可以根据传入的对象，实现1对1的监听
        3.4）缺点，对代码有耦合          
            
               