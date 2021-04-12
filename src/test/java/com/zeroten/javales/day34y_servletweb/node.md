#### JDBC+Servlet项目练习题
   三层架构：DAO(持久层)、Service(业务层)、Action(界面层 
   是业务层的一部分，是一个管理器 （总开关），取出前台界面的数据，调用service方法，转发到下一个action或者页面)
  （1）简单的列表、增、删、改、分页
         
    建表
    CREATE TABLE IF NOT EXISTS books (
    	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    	name varchar(20) NOT NULL,
    	author varchar(20) NOT NULL,
    	create_time datetime NOT NULL DEFAULT NOW()
    ) ENGINE=InnoDB CHARSET=utf8;
    
  （2）需求实现步骤：最直观的体现就是建表
     2.1）数据建模
     2.2）建实体类
     2.3）设计页面
     2.4）工程的结构
     2.5）DAO编写：30%的工作量基本都集中在DAO的编写，这写完其他地方都好写
     2.6）service的编写
     2.7）controller的编写，分发
        2.7.1）增删改查
            2.7.1.1）查：分页查
                1.7.1.1.1）当前页数
                1.7.1.1.2）总页数
                1.7.1.1.3）总记录数
                1.7.1.1.4）偏移量
                1.7.1.1.5）分页大小
            2.7.1.2）删除
            2.7.1.3）新增和修改通过id来区分
            2.7.1.4）但凡需要用到后台数据的地方，都要先请求后台，再转入前台
  （3）大工程，复杂的工程就是把（2）的步骤封装成一个个模块实现  
  
  创建IDEA创建web项目慢，在maven的Runner中添加-DarchetypeCatalog=internal(catalog.xml改成本地获取)配置，
  可以提速。
  
  练习十套：至少一周交一套。
  
  JDBC+Servlet两天一个项目
  java达到精通要把每一类中间件都会，至少知道怎么用？干什么的？有什么优缺点？
  其次就是业务这块要会设计 脑海中要有这么个概念，数据从哪来？到哪去？会有哪些变化？
