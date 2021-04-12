### 1.查询
    1) Statement
    2) PreparedStatement 
### 2.修改数据
     1) 增删改，肯定要有事务
     2）在JDBC当中，修改数据，默认是没有事务管理的
     3) 在JDBC当中，事务管理使用，需要先打开事务管理，不自动提交
        3.1) setAutoCommit(false)：不自动提交
        3.2）commit()：手动提交
        3.3) rollback(): 事务回滚
     4）批量插入数据
        4.1）excuteUpdate()：一次插入一条，一起提交，可以实现目的，但是不推荐，因为每次都要重新编译sql
        4.2) addBatch()：批量添加sql语句
        4.3) excuteBacth()：批量执行sql语句   
     5) 进一步封装JDBC
        5.1) 写一个通用的查询，用泛型来设计  
        5.2）封装JDBC主要目的是了解封装的一些基本概念，以及回顾之前的内容，不是为了做到这一步 