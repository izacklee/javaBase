2020.06.09
#### 1.MyBatis（所有框架中最简单易学的框架 框架足够简单 足够灵活才能存活得更久）
   1）MyBatis的API
   2）MyBatis的动态SQL（核心内容 必须掌握）
#### 2.MyBatis的配置文件
   MyBatis相关依赖：
        mysql-connector-java 5.1.48
        mybatis 3.4.6
   1）核心配置（configuration.xml）：后期会取消该配置文件
   2）映射文件（mapper.xml）：学习重点
   3）MyBatis核心类的生命周期（面试小概率问，实际开发一般不会用）
    3.1）SqlSessionFactoryBuilder：用过即丢（渣男）
        3.1.2）读取配置文件，使用Resources对象的getResourceAsStream静态方法
    3.2）SqlSessionFactory：是一个单例，用于生产SqlSession的
    3.3）SqlSession：相当于JDBC所用的Connection（连接与操作数据库），只不过更强大，提供的API更加丰富。
        包含了执行sql需要的所有方法，可以通过SqlSession实例直接运行映射的sql语句。
        3.3.1）生命周期：手动获取，关闭则死亡
        3.3.2）线程不安全，不能共用（不要放在单例里用，不要是静态的），每个线程使用自己独立的SqlSession
        3.3.3）SqlSession可以一直用（执行SQL），直到关闭。
   4）映射配置文件
    4.1）namespace：命名域
    4.2）select：查询
        4.2.1）id：对应的方法名
        4.2.2）parameterType：参数类型
            a 如果是实例，那么直接写该实例类型parameterType，注意有parameterMap（很早就废弃了 
                一定不要用 之所以看到是为了兼容早期版本）
            b 如果是基本数据类型，可到mybatis官网查看别名填写，
                地址：https://mybatis.org/mybatis-3/zh/configuration.html#properties    
        4.2.3）resultType：返回值类型（有别名可用别名，没有用全路径） 
        4.2.4）resultMap：结果集映射，不需要再重复写列别名
                type：指向实体类
                id：可自定义，在select里用
                resultType直接映射到具体实例，无论是List还是单个实体，都可以直接用实例类型或者resultMap，
                同一个标签当中resultMap和resultType，不可同时存在。
        4.2.5）非实例参数，表达式名字随便填写，如#{deptno} 大括号里的名字可随便写 比如也可写为id
    4.3）insert：插入
        增删改的标签属性只有参数类型，返回值类型默认int，即影响到的数据量。
    4.4）update：更新
    4.5）delete：删除
    4.6）动态SQL元素标签（MyBatis最强大的特性之一就是它的动态语句功能，使用动态SQL完成多条件查询）：必须掌握！！！
        if
        choose、when、otherwise // 相当于if else
        trim、where、set
        foreach
   下节课SSM整合的工作，以及一些零散的小知识点。
   下下节课项目管理工具