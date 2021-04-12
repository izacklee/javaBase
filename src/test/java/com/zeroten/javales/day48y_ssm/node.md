2020.06.12
开发更多的是用SpringBoot（是Spring的一套快速配置脚手架 为什么能火? 因为大项目SSM依赖的整合太多太复杂了）和SpringCloud
（Spring Cloud是一个基于Spring Boot实现的云应用开发工具。本身不会提供具体功能性的操作，依赖于Spring Boot开发，
 更专注于服务之间的通讯、熔断、监控等）
#### 1 SSM依赖
  1）Servlet JDBC 和 Log4j基础依赖
    jstl 1.2
    jsp-api 1.2
    standard 1.1.2
    mysql-connector-java 5.1.30
    commons-dbcp 1.2.2
    log4j 1.2.17
    fastjson 1.7.7
    slf4j-api 1.7.7
    slf4j-log4j12 1.7.7
  2）JSON映射 和 上传组件基础依赖
    jackson-mapper-asl 1.9.13
    jackson-core 2.1.0
    jackson-databind 2.1.0
    jackson-annotations 2.1.0
    commons-fileupload 1.3.1
    commons-io 2.4
    commons-codec 1.9
  3）Spring依赖
    spring-core 4.0.2.RELEASE
    spring-web 4.0.2.RELEASE
    spring-oxm 4.0.2.RELEASE
    spring-tx 4.0.2.RELEASE
    spring-jdbc 4.0.2.RELEASE
    spring-webmvc 4.0.2.RELEASE
    spring-aop 4.0.2.RELEASE
    spring-aspects 4.0.2.RELEASE
    spring-context-support 4.0.2.RELEASE
    spring-test 4.0.2.RELEASE
  4）动态代理和AOP增强依赖
    aspectjrt 1.6.11
    aspectjweaver 1.6.11
    cglib 2.1_3
  5）MyBatis和Spring-MyBatis整合依赖
    mybatis 3.2.6
    mybatis-spring 1.2.2