### 1.JDBC(Java Database Connectivity)
   （1）JDBC是数据库持久化技术，也就是将数据永久保存到磁盘上，通常由关系型数据库完成
   （2）学习目标，是掌握JDBC的API操作
    (3) JDBC针对不同的数据库，提供了对应的驱动程序
### 2.掌握JDBC的API操作
   （1）安装mysql的驱动5.1.48
        mysql不同版本驱动加载的路径
        Connector/J 8.0+ : com.mysql.cj.Driver
        connector/J 8.0- : com.mysql.jdbc.Driver
   （2）加载驱动
   （3）访问协议与获取连接
        1) jdbc:mysql://localhost:3306/test
        2) 用户名
        3）密码    
   （5）建立查询通道（获取Statement）
        1) createStatement 存在安全隐患，sql注入
        2）preparedStatement 建议使用这个 
   （5）执行查询，并返回结果集ResultSet
   （6）遍历查询结果
   （7）获取查询数据
        1）可根据列名获取
        2）也可以根据列所在位置来获取
        3）数据获取要符合数据对应的数据类型，和数据库支持的类型
    (8) Statement存在安全隐患，sql注入
        1) 通过给sql语句添加特殊的恒等式，比如：" OR 1 = 1"，会给数据造成安全隐患，可查询出所有的数据
        2 每查询一次，都需要进行一次sql编译的工作，非常消耗性能
   （9）PreparedStatement 预编译查询通道    
        1）使用PreparedStatement取代Statement，预编译查询通道（在执行sql前就完成了编译），提高安全性 
        2）需要传递的参数用?代替，?叫占位符
        3）传递的参数，从1开始
        4）如果不确定参数类型，可以使用setObject方法传参   
        5）往占位符当中传的数据，都是使用字符串形式进行包裹，能够有效避免sql注入
            比如：empno = ? , ? 传入1 OR 1 = 1，实际相当于empno = '1' OR 1 = 1，使其变得无意义
### 3.持久层的编码规则
   （1）通常来说，持久层是要建立一个dao包，用于存放dao接口
   （2）持久层的实现类是放在dao包下的impl包当中
        2.1) base层作用：封装数据库的基础操作
   （3）与dao平级建立一个entity包，用于存放实体类(对应表)  
   （4）创建BaseDao
    (5) 实现动态sql组装和传参       