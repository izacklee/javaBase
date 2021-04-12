2020.06.07
#### 1.SpringMVC一次请求的完整生命周期
   SpringMVC是结构最清晰的MVC Model2实现
#### 2.SpringMVC的特点 
   SpringMVC相关依赖：
         spring部分的依赖 基础依赖：4.3.27
           spring-core
           spring-beans
           spring-context
           spring-context-support
           spring-web
           spring-webmvc
           spring-tx
           spring-aop
           spring-aspects
         javaEE相关的依赖：
            javax.servlet-api 3.0.1
            javax.servlet.jsp-api 2.2.1
            jstl 1.2
            standard 1.1.2   
         springmvc自动转jSON的jar包依赖：
            jackson-core  2.6.7
            jackson-annotations 2.6.7
            jackson-databind 2.6.7.3
         文件上传依赖：
            commons-fileupload 1.4
            commons-io 2.7
  （1）Spring的亲儿子（SpringMVC将Spring封装得很优秀 几乎不需要添加额外的东西）
  （2）非常灵活
  （3）SpringMVC：配置文件的工程路径/WEB-INF/mvc-servlet.xml
  （4）SpringMVC注解模式
      @Controller：controller
      @RequestMapping：可自定义访问类和方法名
      @PathVariable：默认情况下，参数可以是任意类型或者对象
      @RequestParam：可自定义参数名
      ant风格：
        4.1）?：匹配一个字符
        4.2）*：匹配0到多个字符，可为空
        4.3）**：在路径中可匹配任意长度路径，用法如：/test10/t/**/{arg1}
  （5）文件上传
        5.1）post提交
        5.2）添加上传属性enctype="multipart/form-data"
        5.3）controller的MultipartFile接收
  （6）Json：Rest风格
        6.1）需要设置json相应的实例映射
        6.2）防止ie浏览器将json数据直接下载下来
        注意配置文件MappingJackson2HttpMessageConverter的选择，springMVC版本4以上的有Http前多个2
#### 3.个人简历
   1.个人信息
   2.教育经历
   3.技能掌握
    3.1 j2se：36个月
    3.2 MySQL：36个月
    3.3 精通（在项目中用过），掌握（写过demo），了解（看过没用过），听过。。。
   4.工作经历（1年1-2个，不要超过4个）
   5.项目经历
    5.1 项目描述
    5.2 项目技术（内部框架，可以描述一下框架）
    5.3 项目规模：参与人数/时间周期
    5.4 我参与的模块：（不是用户管理），不要详细的描述实现过程，这个过程是面试的时候口述；写实现思路，
        和设计难点，实际意义。
    5.5 需要有一些春秋笔法和艺术加工   
   6.总体不要超过3页