2021.01.17
#### 1.AOP原理总结
   1）AOP和动态代理关系
    AOP是一种面相切面的编程思想，Spring框架是基于动态代理实现了AOP。
   2）Spring具体如何实现AOP？
    2.1）Spring切面处理器本质上是一个BeanPostProcessor（是Spring IOC容器给我们提供的一个扩展接口）
    2.2）在BeanPostProcessor的后置初始化方法里面实现了具体的代理逻辑
    2.3）Spring会解析配置的切点（切点：正则表达式，去做（包、类、方法、参数）匹配的一个方法）是否能够命中
        连接点（连接点：类的具体方法），如果能够命中，那么Spring会通过动态代理生成一个代理类来替换原始类。
    2.4）通过代理类来实现AOP的具体逻辑。
#### 2.SpringBoot（框架，优点可以简化配置文件（只要简单的配置声明下就行）)
   Spring的核心就是容器（bean）
   最初写接口是用Servlet，请求、转发、页面都在一个大的项目里，效率低，结构不清晰，而且非常的重，这时候就延伸出来了
   许许多多的MVC框架，SpringBoot就是其中一种。
   看下SpringBoot的jar包，JarLauncher可执行jar包（基础jar包）的入口类文件源码，BootApplication自定义jar包（框架
   jar包）的入口类文件源码。 不能把JarLauncher入口类去掉只保留BootApplication入口类，这样会导致基础jar包无法执行。       