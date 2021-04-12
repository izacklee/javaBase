2020.06.02
忠告：精力主要放在底层的技术应用，而框架是尽可能的多学，不要为了学框架而学框架，因为基本上3-5年就更新一次，框架也是人写的。
做到不看视频，自己也能动手配置出来为止。

#### 1. 企业级框架：针对于公司，在实际生产当中用到的一种技术，简化开发复杂度演化出来的架构。
   （1）Spring（轻量级 面试三大框架中问得最多的）
        简单来说，Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器框架。
        1.1）IoC：控制反转 连接的中间件：bean->dao bean->service bean->controller
        1.2）aop：在代码前后插入代码
        1.3）Spring的常用注解
   （2）SpringMVC（就是一个MVC框架）
        SpringMVC是基于Spring功能之上添加的Web框架，想用SpringMVC必须先依赖Spring。 可以将SpringMVC类比于Struts。
   （3）MyBatis（是一款优秀的持久层框架，它支持自定义SQL、存储过程以及高级映射）
    国内（轻量级）SSM（Spring+SpringMVC+Mybatis）要求比较高，国外（重量级）SSH（Struct+Spring+Hibernate） 用得多。
    
   Spring优点
    1）低侵入式设计
    2）独立于各种应用服务器
    3）依赖注入特性将组件关系透明化，降低了耦合度
    4）面向切面编程特性允许将通用任务进行集中式处理
    5）与第三方框架的良好整合 
   Spring两大核心技术（面试重点）
    1）控制反转（IoC：Inversion of Control）/依赖注入（DI：Dependency Injection）
    2）面向切面编程（AOP：Aspect Oriented Programming）

#### 2.Spring的核心组件（舞台剧）---容器
   （1）Bean：演员
   （2）Core：道具/幕后
   （3）Context：舞台   

#### 3.解耦（思想）
   （1）使得我们的项目当中的组件，能够自由的组合，实现可插拔试的功能使用。 
   （2）方式：EJB---Spring/AJAX/RPC
        RPC(Romote Procedure Call)：远程过程调用 允许一台计算机程序远程调用另外一台计算机的子程序，
        不用关心底层网络通信。

#### 4.依赖注入DI --- 面试必问
   （1）一个类依赖另一个类才能实现功能，那么将这个类声明后调用的行为，称之为依赖注入。
   （2）是耦合的

#### 5.IoC（控制反转 Spring-最核心的价值）--- 面试必问  
   Spring最核心的价值
   （1）为了解决依赖注入的问题，所以才需要IoC的控制反转来进行解耦
   （2）所以IoC才是解耦的
   （3）IoC的核心，还是在执行依赖注入，只不过这个注入是动态的，是有容器来代替我们完成的。
   
#### 6.Spring的应用
   搭建流程：
    1）添加依赖
    2）配置文件
    3）创建接口和实现类
    4）完成bean的注册和注入
   关键依赖：
    1）spring-context-3.0.7.RELEASE.jar
    2）spring-aop-3.0.7.RELEASE.jar
    3）spring-expression-3.0.7.RELEASE.jar
    4）spring-core-3.0.7.RELEASE.jar
    5）spring-beans-3.0.7.RELEASE.jar
        Bean：就是JAVA当中的对象
            a 以后项目当中，无论什么组件，第一件事就是想办法把他注册到容器当中
            b 最好的实现方式是面相接口编程（编码时使用接口而不是具体的对象）
                那为什么要面向接口编程呢？其实主要是为了解耦。我定义一个接口，我甚至不知道别人会怎样实现它，
                我的系统用谁的具体实现都能正常工作，甚至没有具体实现也能正常工作，别人一点都不会影响我，这就是解耦。
        BeanFactory：获取容器
            a 使用了延时加载，获取bean的时候，才创建实例
            b 已废弃，不推荐使用
            c 废弃的原因：延时加载最大的弊端，不便于检查配置当中可能存在的错误（应该先检查再获取）。
        ApplicationContext：获取容器
            a 在容器加载的时候，就已经完成了对单例对象的实例化
            b 推荐使用，可以尽可能的规避配置当中出现的问题
            c 可以加载多个配置文件（Spring的配置文件可以有多个）
        Spring当中，bean的默认作用域是什么？怎么改？在哪改？
            默认作用域（非必要是不用）：单例。存在的问题，单例在并发的情况下，通常是不安全的（比如属性修改 
                做web所有的请求都是并发进来，用单例就出现问题了）。
                优点：事先加载，那么在使用的时候不需要及时加载，所以调用效率高
            prototype（推荐）：每次获取一个新的实例，在容器加载的时候不会实例化任何对象。
                可通过配置scope="prototype"实现（singleton（单例）/prototype（多例））。
                优点：使用的时候再加载，调用效率低，但是安全。
            静态工厂模式获取（一般不用），也是在获取bean的时候创建实例。
                优点：介于默认和prototype之间。效率高于prototype，但是低于单例，相对安全（因为是静态的）。
        Bean的属性注入/Bean的初始化
            a 对象注入：默认情况下，spring的注入需要提供getter/setter
            b ref：完成对象的注入
            c value：完成值的注入
            d constructor-arg：构造方法注入
            e 注入Array，List，Set
            f 注入Map，Properties