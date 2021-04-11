### 1.事务：掌握使用规则和特点
   1）将一组sql语句放一起执行，
   2）只要有一个sql出错，则该批次的所有sql都将被取消
   3）要么全部成功，要么全部失败
   4）mysql事务管理只支持Innodb和BDB类型数据表类型
   5）ACID(四个基本要素)：
      5.1）原子性(Atomic)：要么全部成功，要么全失败（sql）
      5.2）一致性(Consist)：一个事务从开始到结束，数据的完整性没有被破坏（数据）
            完整性
            5.2.1）从数据库方面来说，事务操作结束后，索引、外键等没被破坏
            5.2.2）从业务方面来说，新增删除数据，关联性不受影响。
      5.3）隔离性(Isolated)：互不干扰
      5.4）持久性(Durable)：提交全保存（保存硬盘）
   6）mysql当中的事务默认是开启自动提交的，即立即执行语句，将数据持久化到数据库 
 * 7）操作事务的几个步骤（必须会）：
      7.1）关闭自动提交
      7.2）开启事务
      7.3）执行更新数据语句
      7.4）提交/回滚
      7.5）执行提交或回滚，即当前事务结束，事务只对当前会话有效；如果会话关闭(客户端和数据库连接断开)，
           则需要再次设置关闭自动提交，开启事务
      练习：
        # 手动提交
        SET autocommit = 0;
        # 自动提交
        SET autocommit = 1;
        
        # 开启事务
        START TRANSACTION;
        
        
        SELECT * FROM dept;
        INSERT INTO dept(deptno, dname, loc) VALUES (201, "TECHNOLOGY", "BEIJING"),
        (202, "TECHNOLOGY", "SHANGHAI"); 
        DELETE FROM dept WHERE deptno IN (201, 202);
        
        /*
        没有回滚或提交数据 只要查出来了 其实数据已经保存到mysql的data文件里了
        my.ini
        my.cnf
        logfile0 # 0 1文件是记录当前事务未提交的状态
        logfile1
        */
        
        # 提交
        COMMIT;
        # 回滚
        ROLLBACK;     
   8）事务的隔离级别（面试会问）：
      隔离级别，每一个事务互不影响。
      8.1）脏读
         一个事务修改数据，另一个事务读取该数据，如果修改的数据未提交，回滚了，
         那么另一个事务读取到的数据就是脏读。
      8.2）不可重复读
         两次读取不到一致的数据
         一个事务先查询数据，另一个事务修改该数据并提交，前面的事务再次回来查询，
         发现两次查询的数据不一致就是不可重复读
      8.3）幻读        
        一个事务先查询某一批数据，另一个事务新增数据并提交，前面的事务再回来查询，
        发现两次查询的数量不一致就是幻读。
        与不可重复读的区别是不可重复读的重点是修改，幻读的重点在于新增或者删除记录，读出来的记录数不一样。
        对于前者, 只需要锁住满足条件的记录。 对于后者, 要锁住满足条件及其相近的记录
   9）四种隔离级别（面试会问）：
     9.1）Read Uncommitted 未提交读 --未解决并发问题（极不安全）
        事务未提交对其他事务也是可见的，脏读(dirty read)
     9.2）Read Committed 提交读 --解决脏读的问题
        一个事务开启后，只能看到自己所做的修改，不可重复读(non repeatable read)
        需要修改处于事务当中
     9.3) Repeatable Read 可重复读 --解决不可重复读的问题(InnoDB) 
        同一个事务中多次读取的数据一致，也可解决脏读，幻读
        需要查询、修改处于事务当中
     9.4) Serializable 串行化 --解决所有问题（啥都不允许，不管增删改查，都是排他锁，缺点是太慢了）
        最高的隔离级别，通过强制事务的串行执行  
     练习：

        # 设置全局隔离级别 -- READ UNCOMMITTED 未提交读 可以读到未提交的数据
        SET GLOBAL TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
        # 设置当前会话隔离级别 - READ UNCOMMITTED 未提交读 可以读取到未提交的数据
        SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
        
        # Repeatable Read 可重复读 -- 解决不可重复读的问题(也能解决脏读、幻读的问题)
        SET GLOBAL TRANSACTION ISOLATION LEVEL REPEATABLE READ;
        SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
        
        # Serializable 串行化 -- 解决所有问题
        SET GLOBAL TRANSACTION ISOLATION LEVEL SERIALIZABLE;
        SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
        # 查看全局隔离级别
        SELECT @@global.tx_isolation;
        # 查看当前会话隔离级别
        SELECT @@tx_isolation;
        
        
        # 自动提交
        SET autocommit = 1;
        
        # 手动提交
        SET autocommit = 0;
        
        # 开启事务
        START TRANSACTION;
        
        
        # 添加字段
        ALTER TABLE dept_auxiliary ADD deptno int(11) UNSIGNED NOT NULL COMMENT "id";
        # 添加主键
        ALTER TABLE dept_auxiliary ADD PRIMARY KEY(deptno);
        # 给主键添加自增长 
        ALTER TABLE dept_auxiliary MODIFY deptno int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT "id";
        # 修改表的字符集
        ALTER TABLE dept_auxiliary CHARACTER SET UTF8;
        # 修改表的引擎类型
        ALTER TABLE dept_auxiliary ENGINE=InnoDB;
        DESC dept_auxiliary;
        SHOW CREATE TABLE dept_auxiliary;
        
        SELECT * FROM dept_auxiliary;
        UPDATE dept_auxiliary SET dname = 'AAA' WHERE deptno = 201;
        INSERT INTO dept_auxiliary(deptno, dname, loc) VALUES (201, "TECHNOLOGY", "BEIJING"),
        (202, "TECHNOLOGY", "SHANGHAI"); 
        DELETE FROM dept_auxiliary WHERE deptno IN (201, 202);
       
        # 提交
        COMMIT;
        # 回滚
        ROLLBACK;       
### 2.锁：要会用，了解基本概念
  （1）锁是用于管理不同事务对共享资源并发访问
  （2）表锁与行锁
       1）mysql实际上不存在表锁，表锁通过对所有的行锁实现的
       2）只针对某一行加锁，叫行锁。
       3）字段设置索引才是行锁，不设置则为表锁
  （3）共享锁
       1）多个数据共享一把锁，只能查不能改，解决不可重复读，保证在查的时候数据的绝对安全（业务使用，比如系统维护、财务统计）
  （4）排他锁
       1）当某个查询持锁（都持锁状态），既不能查，也不能改 
  （5）意向锁
       InnoDB数据操作之前自动加的，不需要用户干预
       1）意向共享锁(IS)
            加共享锁前必须先获取IS，IS之间是相互兼容的
       2）意向排它锁(IX)
            加排他锁前必须先获取IX，IX之间是相互兼容的
  （6）自增锁
       1）插入数据，执行回滚，ID永久丢失，再次插入会生成新的ID。事务未提交，ID永久丢失。
  （7）临键锁
       1）在查询范围当中，有数据命中的，就是临键锁。  
  （8）间隙锁
       1）在查询范围当中，没有被命中的，就是间隙锁。（例子：插入锁的范围内数据） 
  （9）记录锁
       1）当 SQL 执行按照唯一性（Primary key、Unique key）索引进行数据的检索时，查询条件等值匹配且查询的数据是存在，
          这时 SQL 语句加上的锁即为记录锁 Record Locks，锁住具体的索引项。
       2）当锁上某一个记录，都属于记录锁。               
  （10）死锁
       1）在事务中修改数据，默认改行为死锁。
       2）当两个事务中，同时持有对方的锁时，发生死锁    
   练习：
   
      # 设置全局隔离级别 -- READ UNCOMMITTED 未提交读 可以读到未提交的数据
      SET GLOBAL TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
      # 设置当前会话隔离级别 - READ UNCOMMITTED 未提交读 可以读取到未提交的数据
      SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
      
      # Repeatable Read 可重复读 -- 解决不可重复读的问题(也能解决脏读、幻读的问题)
      SET GLOBAL TRANSACTION ISOLATION LEVEL REPEATABLE READ;
      SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
      
      # Serializable 串行化 -- 解决所有问题
      SET GLOBAL TRANSACTION ISOLATION LEVEL SERIALIZABLE;
      SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
      # 查看全局隔离级别
      SELECT @@global.tx_isolation;
      # 查看当前会话隔离级别
      SELECT @@tx_isolation;
      
      
      # 自动提交
      SET autocommit = 1;
      
      # 手动提交
      SET autocommit = 0;
      
      # 开启事务1
      START TRANSACTION;
      
      
      SELECT * FROM dept_auxiliary;
      UPDATE dept_auxiliary SET dname = 'AAA' WHERE deptno > 201;
      INSERT INTO dept_auxiliary(deptno, dname, loc) VALUES (201, "TECHNOLOGY", "BEIJING"),
      (202, "TECHNOLOGY", "SHANGHAI"); 
      INSERT INTO dept_auxiliary (dname, loc) VALUES ('TECHNOLOGY', 'BEIJING');
      DELETE FROM dept_auxiliary WHERE deptno IN (201, 202);
      DELETE FROM dept_auxiliary WHERE deptno = 207;
      
      # 共享锁 不加条件就是锁表
      SELECT * FROM dept_auxiliary WHERE deptno = 201 LOCK IN SHARE MODE;
      
      # 排他锁
      SELECT * FROM dept_auxiliary WHERE deptno = 202 FOR UPDATE;
      # 不在索引上的排他锁 --为表锁
      SELECT * FROM dept_auxiliary WHERE loc = 'BEIJING' FOR UPDATE;
      
      # 临键锁
      SELECT * FROM dept_auxiliary WHERE deptno BETWEEN 202 AND 205 FOR UPDATE;
      
      # 间隙锁 -- 插入 deptno 209不存在
      SELECT * FROM dept_auxiliary WHERE deptno BETWEEN 208 AND 210 LOCK IN SHARE MODE;
      # 间隙锁 间隙锁插入
      INSERT INTO dept_auxiliary (deptno, dname, loc) VALUES (300, 'TECHNOLOGY2', 'BEIJING2');
      
      # 死锁
      UPDATE dept_auxiliary SET dname = "111" WHERE deptno = 208;
      UPDATE emp2 SET ename = '222' WHERE empno = 7935;
      
      # 查看当前步长
      SHOW VARIABLES LIKE 'innodb_autoinc_lock_mode';
      
      
      # 提交
      COMMIT;
      # 回滚
      ROLLBACK;         