#### 1.行为型设计模式
   4）模板方法（TemplateMethod）：封装了不变的部分，扩展可变部分（不变部分封装到父类实现，而把可变部分由子类继承实现）。
    用途：定义一个操作中的算法骨架，而将一些步骤延迟到子类中。TemplateMethod使得子类可以不改变一个算法的结构即可重定义该
        算法的某些特定步骤。
    场景：
        a、实现算法的不变部分，并将可变的行为留给子类来实现。
        b、各子类中的公共行为应被提取出来并集中到一个公共父类中以避免代码重复。
    已知应用：AbstractQueueSynchronizer
#### 2.Spring原理
   JAVA中Bean是一个类，一个可复用的类。javaBean在MVC设计模型中是model，又称模型层。
   1）Spring是什么？
    Spring是一个轻量级的控制反转（IoC)和面向切面（AOP）的容器框架。
   2）为什么要用Spring，解决了什么问题？
    Spring的主要技术就是依赖注入，控制反转（就是把创建对象这个功能交给spring了，自己不用创建了，不用new了）和AOP切面编程；
    Spring可以把Struts和Hibernate(当然不是只针对这两种框架)经行解耦。
    Spring容器可以解决视图层和持久化层很多方面耦合的问题（比如，创建和使用耦合）。
    （要是不用Spring容器，那么视图层和持久化层很多方面就会耦合在一起；
    对于以后的控制和扩展性，都是一个困难；
    Spring加入之后放在中间实现了解耦）。
   3）怎么解决的？
    将Spring加入视图层和持久化层中间实现解耦。
   4）Spring的优缺点
    4.1）优点：
        4.1.1）从大小与开销两方面而言Spring都是轻量级的；
        4.1.2）通过控制反转(IoC)的技术达到松耦合的目的（xml不需要重新编译，因此实现了“彻底解耦”）；
        4.1.3）提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑与系统级服务进行内聚性的开发；
        4.1.4）包含并管理应用对象(Bean)的配置和生命周期，这个意义上是一个容器；
        4.1.5）将简单的组件配置、组合成为复杂的应用，这个意义上是一个框架。
    4.2）缺点：
       4.2.1）使用门槛升高，入门Spring需要较长时间；
       4.2.2）对过时技术兼容，导致复杂度升高；
       4.2.3）使用XML进行配置，但已不是流行配置方式（原因是太累了，现在流行使用注解（使用比较多）、Java配置类的方式代替XML）；
       4.2.4）集成第三方工具时候需要考虑兼容性；
       4.2.5）系统启动慢，不具备热部署功能，完全依赖虚拟机或Web服务器的热部署。 
              热部署：对于Java应用程序来说，热部署就是在运行时更新Java类文件。

#### 3.Spring创建Bean相关问题？
   作用域：原型每次使用都要实例化，单例在容器中只实例化一次。
#### 4.Bean定义
   1）Bean定义：根据配置文件或者注解加载Bean定义到BeanDefinitionMap。
   2）三种方式：
    2.1）基于XML
        <beanid="userService"class="com.javhl.***.UserService"init-method="init"destory-method="destory"/>
    2.2）基于注解
        @Component：当对组件的层次难以定位的时候使用这个注解
        @Controller：表示控制层的组件
        @Service：表示业务逻辑层的组件
        @Repository：表示数据访问层的组件
    2.3）基于JavaConfig
        @Configuration
        public class JavaConfigBeanTest{
            @Bean
            public BeanTest beanTest(){
                BeanTest beanTest = new BeanTest();
                beanTest.setTestField("I am a beanTest");
                return beanTest;
            }
        }
