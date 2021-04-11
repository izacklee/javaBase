### 1.学习目标
    (1) DDL(CREATE、DROP、ALTER)：掌握
    (2) DML(INSERT、UPDATE、DELETE)：掌握
    (3) DQL(SELECT)：掌握
    (4) 函数：掌握
    (5) 索引
        1) 概念和应用：掌握
        2) 原理：理解
        3）执行计划：了解
        4）优化：理解
     6) 事务
        1) 概念和应用：掌握
        2）事务隔离和锁：理解
### 2.MySQL数据库
   （1）关系型数据库：业务数据库(时效性高，数据的同步操作安全，是可以以面相对象的形式设计数据库模型)
   （2）W3C标准SQL语法
   （3）非关系型数据库：NoSQL（数据仓库）         
### 3.什么是数据库
   （1）DNMS(Database Management System)：数据库管理系统
   （2）数据库  
### 4.库和表的关系
   （1）一组数据表的集合叫库，mysql当中可以建若干个库 
   （2）数据容量：24W-TB
   （3）单张表：
        1）1024个字段
        2）4000W+数据
   （4）并发150+
### 5.建库
   （1）在mysql当中，字段内容是区分大小写的，其他的大小写不敏感。
   （2）切换库：要使用某一张表，首先需要先选中该表所在的库，不选中会报错。
        1）不切换库，可直接使用"库名.表名"查询
        2）库名新建成功后，不可修改
   （3）反引号
        1）反引号示例：``  
        2）不是关键字，可以不加反引号
        3）单引号是字符串，字符串不区分单引号和双引号 
### 6.建表
   （1）字段：列
   （2）字段的数据类型：
        1）数值
            a.非常小的数据：tinyint
            b.标准整数：int(11)
            c.浮点数：double(7,2) // 数值类型，在索引树上很好找，也很好判断。建议多使用，不建议使用字符串类型
        2）字符串
            a.char：索引快，费空间，上限容量小（固定长度，0~255包含边界值）
            b.varchar：索引相对慢，省空间，上限容量大（可变长度，0~65536包含边界值）
            c.text：文本串(容量2^16-1字节) 
        3）时间
            a.DATETIME：yyyy-MM-dd hh:mm:ss // 有时区问题（如不需要考虑时区，并发时推荐）
            b.TIMESTAMP：yyyyMMddhhmmss // 存在单个用户计算时区问题
            c.varchar/bigint：1970-1-1 0:0:0-当前毫秒数 // 推荐 不考虑毫秒时用INT
            // TINYINT（1个字节 默认值4） INT（4个字节 默认值11）BIGINT（8个字节 默认值20）  
            插入效率：DATETIME > TIMESTAMP > INT 读取效率：INT > TIMESTAMP > DATETIME
            储存空间：DATETIME > TIMESTAMP = INT
        4）NULL  
            a.代表没有
            b.不可以参与数值运算，否则结果是null
            c.0/null=false; 1=true 
    （3）属性
        1）是用于设置当前字段特征 
        2）UNSIGNED(无符号)：只能是正数，不能是负数 
        3）ZEROFILL：0填充（以0来补位）
        4）AUTO_INCREMENT：自增长，通常用于设置主键，且为整型数值，默认是1
            如果是Oracle，需要自己创建序列
        5）NULL和NOT NULL：当前列是否为空
        6）DEFAULT默认值：给该列设置默认值，可以和NOT NULL配合使用 
    （4）注释：对表或字段，写注释
    （5）表类型（数据引擎）：
        MyISAM：可以当做数据仓库用，用于数据归档，也就是那些不需要频繁修改的数据，
                或者或可以作为数据增量表(就是说表的数据只会增加，不会修改，也不会去删，比如历史订单，其他历史数据)的引擎，
                可以拷贝文件实现数据备份。
        InnoDB(默认)：针对于需要频繁修改，且操作量极大的数据，主要的作用就是保证数据安全，冷备份不可以直接做数据迁移，因为大家都共同用一个。
                    MyISAM          InnoDB
       事务处理      不支持            支持             
       数据行锁定    不支持            支持
       外键约束      不支持            支持
       全文索引      支持             不支持
       表空间大小    较小              较大，约2倍
            1）MyISAM不支持事务(事务决定着数据是否安全)，意味着不安全，高并发的需求不能用
            2）约束，最好不要用。因为如果表做软删除时，可能会出现数据重复，导致出问题
            3) MyISAM的一个优势是支持全文索引，全文索引是针于“字符串”的 
            4）InnoDB查询效率比MyISAM慢很多，但能保证数据安全，因为其支持事务 
            5）MyISAM空间小，因为少了锁，外键，索引等等这些东西，响应速度  
      (6) 主键，是用来标识当前数据行的字段，必须具备唯一性，可以使用不重复的整数，
            也可以使用不重复的字符串（比如：UUID，但UUID被非真的唯一，通常在即存即获取的数据表才用(如果用自增长，由于事务可能id还没生成，id不知道是什么)），
            表当中通常需要设置一个主键，可以有多个。 UUID：通常使用格林威治时间1970-1-1 0:0:0这个数值，对这个数值进行重新编码，
            为了尽可能避免重复，可在时间后面拼接上随机数。
            version：数据版本号（优势：不用排队，事务(同步)要排队）
                例如：在where后面加version = version + 1 AND version = 1的条件
            batch_version：批号，记录某一批数据，便于对其批量处理
            is_delete：逻辑删除（软删除）
            用户体验度：最优是2-7秒之间（并非一定是成功，但一定要给反馈），是到服务器，业务处理+数据库+其他中间件，所有的时间
            
            ## 建库
            # CREATE DATABASE [IF NOT EXISTS] 数据库名;
            # IF NOT EXISTS：不存在则创建库
            CREATE DATABASE IF NOT EXISTS test;
            # 关键字要加反引号
            CREATE DATABASE IF NOT EXISTS `database`;
            
            # 删除库
            # DROP DATABASE [IF EXISTS] 数据库名;
            DROP DATABASE IF EXISTS test;
            
            # 查看数据库：属于一个查询语句
            SHOW DATABASES;
            
            # 使用数据库（切换库）
            USE test;
            
            # 不选中库的查询方式：库名.表名
            SELECT * FROM mysql.user;
            
            # 创建表
            /**
               CREATE TABLE [IF NOT EXISTS] 表名 (
            	`字段1` 列类型[属性][索引][注释],
            	`字段2` 列类型[属性][索引][注释],
            	... ...
            	`字段n` 列类型[属性][索引][注释]
               )[表类型][表字符集][注释];
            */
            CREATE TABLE t1 (
               id int,
               name varchar(255)
            );
            
            # null不可以参与数值运算，否则结果是null
            SELECT NULL*123;
            
            # 创建表语句
            CREATE TABLE `USER_TABLE` (
              `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
              `username` varchar(20) CHARACTER SET latin1 NOT NULL,
              `password` varchar(100) CHARACTER SET latin1 NOT NULL,
              `real_name` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
              `age` int(11) NOT NULL DEFAULT '0',
              `sex` tinyint(1) DEFAULT '1',
              `birthday` date DEFAULT NULL,
              `sal` double(7,2) NOT NULL DEFAULT '0.00',
              `comm` double(7,2) DEFAULT NULL,
              `version` int(10) NOT NULL DEFAULT '1',
              `is_delete` int(10) NOT NULL DEFAULT '1',
              `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
              `update_time` datetime DEFAULT NULL,
              `uuid` varchar(100) NOT NULL,
              PRIMARY KEY (`id`,`uuid`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
            
            # 查看创建数据库语句
            SHOW CREATE DATABASE test;
            
            # 查看创建表语句
            SHOW CREATE TABLE USER_TABLE;
            
            # 修改表的字符集
            ALTER TABLE USER_TABLE CHARACTER SET 'utf8';
            
            # 添加字段
            ALTER TABLE USER_TABLE ADD uuid varchar(100) NOT NULL;
           
            # 查看表结构语句
            DESC USER_TABLE;
            
            # 删除主键（删除主键前先删除自增长，否则会报错：
            # Error : Incorrect table definition; there can be only one auto column and it must be defined as a key）
            ALTER TABLE USER_TABLE DROP PRIMARY KEY;
            
            # 修改列
            ALTER TABLE USER_TABLE MODIFY id int(11) NOT NULL;
            
            # 添加复合主键
            ALTER TABLE USER_TABLE ADD PRIMARY KEY(id,uuid);
            ALTER TABLE USER_TABLE ADD PRIMARY KEY(uuid);
            
            # 把id字段修改为无符号，自增长
            ALTER TABLE USER_TABLE MODIFY id int(11) UNSIGNED AUTO_INCREMENT;
            
            # 删除表
            DROP TABLE USER_TABLE;
       
       大数据量下分库分表的一些问题与解决方法：
           问题：
            （1）如果是分表，那么要分组和排序时问题就大了。 
           解决方法：
            （1）使用中间件解决，比如使用缓存，把所有的数据都查询放到缓存里，然后再分组排序
            （2）还有一个比较简单的方法，就是建个大表，把表都合并到一张表去。
               （两张表数据量都比较大时考虑，如果有其中一张表数据量小，就一些说明的数据，那还是分表）

            
               