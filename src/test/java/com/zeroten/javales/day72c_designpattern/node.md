#### 1.抽象工厂扩展解决方式
   1）枚举方式（最简单）
   2）配置文件方式
    如:bwm: com.zeroten.javales.day72c_designpattern.BmwFactory
   3）注解方式

#### 2.行为型设计模式
   1）责任链（Chain of Responsibility）：使多个对象一个接一个过滤。
    用途：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，
        直到有一个对象处理它为止。
    场景：
        a、有多个对象可以处理一个请求，哪个对象处理该请求运行时自动确定。
        b、你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
        c、可处理一个请求的对象集合被动态指定。
    已知应用：Java Servlet: 1 FilterChain=n Filter+1 Servlet过滤器链，对请求进行过滤；
        Spring MVC:1 HandlerExecutionChain=n HandlerInterceptor+1 handler请求拦截器，对请求进行拦截；
        Spring MVC:1 RequestResponseBodyAdviceChain=m RequestBodyAdvice+n ResponseBodyAdvice如：统一Restful风格的响应状态
   2）迭代器（Iterator）：可以不暴露自身对象内部下按顺序访问集合的各个元素
    用途：提供一种方法顺序访问一个聚合对象中的各个元素，而又不需要暴露该对象的内部表示。
    场景：
        a、访问一个聚合对象的内容而无需暴露它的内部表示。
        b、支持对聚合对象的多种遍历。
        c、为遍历不同的聚合结构提供一个统一的接口。
    已知应用：ArrayList；HashSet。
   3）策略（Strategy）：把定义的一系列算法封装起来，并可独立调用。
    解决问题，典型的例子一大堆if else 问题
    用途：定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
    场景：
        a、许多相关的类只是行为有异。“策略”提供了一种用多个行为中的一个行为来配置一个类的方法。
        b、一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现。将相关的条件分支移入它们各自的策略类中
            以代替这些条件语句。
    已知应用：Arrays.sort；Collections.sort