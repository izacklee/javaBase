2021.1.24
#### SpringBoot原理2
   对BootApplication入口类和入口类中注解的深入分析讲解。
   SpringBoot的核心是自动装配（Ioc），就是按照规范当项目启动的时候把所有组件都加载起来，就不用一大堆的配置。
   没有SpringBoot的情况下去开发一个简单的SpringMVC，都是非常痛苦的，要配置一大堆东西，要对里面的结构非常的清晰才能配置起来，
   否则就会有一大堆的报错。有了SpringBoot就简单多了，只需要关注Controller层，你的业务怎么写就可以了。
   @Import注解的作用是导入类，然后将其注入到容器中。
   
   spring-factories配置与用法案例 