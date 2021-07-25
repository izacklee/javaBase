2021.3.7
#### 1 Spring事务集成到Mybatis上
   Spring通过TransactionSynchronizationManager来将事务同步信息绑定到线程（因为mapper.xml文件很多，绑定到线程上
   才能高效处理），最终判断其是否在事务中，如果在事务中把结果返回，如果不在事务中就直接提交。
   Spring的事务本质上就是一个代理，最终会生成一个代理类。
   mybatis操作数据库的实现逻辑，写个xml文件里写执行的sql，然后mybatis就会自动映射到对应名称的接口，拿到这个接口后
   就可以简单的操作数据库了。
   事务是不能跨连接的，所以提交的事务必须是在同一个连接对象才能生效。 
#### 2 Spring事务与Mybatis集成总结
   1）Spring事务原理：基于AOP实现，TransactionIntercepter（事务拦截器）从事务连接池获取一个连接，并且把这个连接
   （Connection，关闭自动提交）绑定到当前操作的线程（ThreadLocal），TransactionSychronizationManager标识当前
    处于事务中（ThreadLocal）。
   2）Mybatis原理：基于JDK动态代理（接口），MapperFactoryBean，SqlSessionTemplate（线程安全），SqlSessionInteceptor，
    从Spring事务中获取连接，不提交，最终由Spring事务提交。   