2020.1.31
#### 1 SpringMVC实现登录拦截
  1）实现登录
  2）业务逻辑
  3）实现退出
  对返回结果统一处理，方法访问时长统计等。
  注意：异常要手动处理，否则不会走@ControllerAdvice，也就是无法实现拦截统一处理。
  依赖公用的最好在最外层pom.xml文件配置，以保证所有模块使用的都是同一个版本。
  
  案例文件demo的路径：
  javhl-master/app-starter/src/main/java/com/javhl/course/springmvc/controller/HandlerInterceptorTest.java