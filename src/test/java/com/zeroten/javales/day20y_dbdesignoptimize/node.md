### 1.索引
   什么是索引？索引是干什么的？
   （1）索引是数据库表的一种存储结构，主要目的是提高查询速度
   （2）主键索引
        1）主键通常自带索引
        2）主键同时也是唯一索引
        3）主键索引是查询效率最高的索引
        4）建议尽可能的使用主键索引
        5）一个表只能有一个主键索引，一个主键索引可以多个字段
   （3）唯一索引(Unique)
        1）如果某一列，需要考虑唯一性，那么可以建唯一索引
        2）唯一索引建议创建在数值上  
   （4）常规索引(Index)  
        1）最普通的索引
   （5）全文索引(FULLTEXT)
        1）适用于MyISAM数据表引擎
        2）通常是建立在字符串类型的数据上  
   （6）联合索引
        1）不属于索引类型，只是索引的一种应用方法  
   （7）索引准则
        1）索引不是越多越好(一般来说，一张表的索引，不超过表列数的24%，也就是大概1/4)
        2）不要对经常变动的数据字段加索引
        3）小数据量的表建议不要加索引(300以下)
        4）索引一般应加在查询条件的字段上  
        5) 索引要经常维护，尤其是增删改的索引，就是定期把原来的索引删除，重新建
            索引重建的原因：当数据量越来越大时(或者删除了某些索引)，在根节点不变的情况下，有可能导致索引树不均衡，
                          由一次扫描range变成全表扫描index，删除重建，索引结构重新生成             
    (8) * 非聚集索引：在索引树当中，只保存数据的地址，典型的代表MyISAM 
    (9) * 聚合索引(这种实现方式使得主键索引搜索十分高效)：索引就是数据，两者结合在一起的。InnoDB
    (10) * 覆盖索引(Using Index)：不需要搜索主键索引，就能命中目标索引。
### 2.执行计划(EXPLAIN)
   mysql的二级缓存(Using join buffer)，以sql为key，查询结果为value保存，如果查过的数据sql没变化，则下次查询直接从缓存取
   （1）id/select_type/table/partitions
        id：查询的序号，id相同则由上往下执行，不同(子查询)则大的先执行
        select_type：查询的类型，区分普通查询(SIMPLE)，联合查询(UNION RESULT)，子查询(MATERIALIZED)等
        table：显示表名或表别名，<unionM,N> 由id为M，N产生的结果；<subqueryN> 由id为N产生的结果
        partitions：使用的哪个分区，需要结合表分区才可以看到，值为NULL表示非分区表
        练习：
            # 联合查询 UNION（UNION：用于连接第二个或后面的查询语句）
            # 相当于 SELECT * FROM emp WHERE deptno = 10 OR sal > 2000;
            # <union1,2> 
            EXPLAIN  
            SELECT * FROM emp e1 WHERE deptno = 10
            UNION 
            SELECT * FROM emp e2 WHERE sal > 2000;
   （2）type 执行计划中很重要的一个指标
        1) 执行速度排序：system > const > eq_ref > ref > range > index > All  
            1.1) system：系统表，少量数据，往往不需要磁盘IO
                // dept4 表引擎为MyISAM 表中只有一条数据的时候出现
                EXPLAIN SELECT * FROM dept4;
            1.2) const：常量连接，直接命中(等值判断)索引，效率最高的索引
                EXPLAIN SELECT * FROM dept WHERE deptno = 10;
            1.3）eq_ref：主键索引(primary key)或者非空唯一索引(unique not null)等值扫描
                不管是主键，还是外键，查询一对一的关系时出现
                EXPLAIN SELECT e1.ename, e2.job FROM emp e1, emp e2 WHERE e1.empno=e2.mgr;
            1.4）ref：非主键或非空唯一索引等值扫描
                一对多的情况下，eq_ref会降级为ref
                EXPLAIN SELECT e.ename, d.deptno FROM emp e, dept5 d WHERE e.deptno=d.id;
            1.5）range：范围扫描，在索引上的一次扫描，和index都属于范围扫描，用索引树分析区别是range只做但一侧扫描，index做两侧扫描
                EXPLAIN SELECT * FROM dept WHERE deptno > 10;
            1.6）index：索引树扫描(覆盖索引)，包含根节点左右两边的数据时为覆盖索引，就是在索引树上的全表扫描
                EXPLAIN SELECT mgr FROM emp WHERE  mgr LIKE "%A%"; # 覆盖索引 Using index
            1.7）ALL：全表扫描(full table scan) ，不在索引上的全表扫描，至少查两次 
            1.8）...等等 
   （3）possible_keys： 可能用到的索引
   （4）key：实际用到的索引
   （5）key_len：索引长度(使用的字节数)，非实际使用长度，越短越好。条件越多，结果越精确，key_len越长，
            所以在能查询到相同结果下，条件越少越好 
   （6）rows：查询返回结果的行数，越小越好
   （7）filtered：实际读取行数的百分比，越大越好
   （8）Extra：一些额外信息，比如：Using where； Using filesort;  
### 3.索引失效
   （1）OR两边都有索引才生效
   （2）负向查询：not,!=,<>,!>,!<,not in, not like等，负向查询并不一定就会导致索引失效，具体还得看mysql的优化器
    (3) 数据库表字段设计时，不建议使用null，可以给个默认值。比如当索引字段为null时，使用is null或not is null可能导致索引失效
        null占用空间大，mysql解析复杂，性能低
   （4）索引字段上使用内置函数，索引一定失效
       EXPLAIN SELECT * FROM emp WHERE  ROUND(comm) = 5000.00; // 字段名不能改！！！
       EXPLAIN SELECT * FROM emp WHERE  comm*12 = 5000.00; 
   （5）组合索引：遵循左侧最优原则，也就是WHERE查询的字段使用组合索引，最左边的字段一定要有
        # 组合索引：index = `sal`, `comm`, `deptno`  最左匹配原则，也就是sal必须要有
        EXPLAIN SELECT ename FROM emp WHERE sal=3000; # 索引有效
        EXPLAIN SELECT ename FROM emp WHERE comm=3000 AND deptno=10; # 索引失效
### 4.SQL优化
   （1）WHERE条件语句优化：
        1）WHERE子句中的连接顺序，自右向左解析，因此使用时建议ON表连接的条件写在WHERE最左边(否则可能产生笛卡尔积)，
            容易导致索引失效的写最左边，过滤范围最大的写WHERE最右边。
            EXPLAIN SELECT ename FROM emp WHERE comm IS NOT NULL AND job LIKE "%A%" AND sal>3000;
        2）不要使用隐式转换
            EXPLAIN SELECT ename FROM emp WHERE deptno="20"; # deptno为int 这么写会发生隐式转换
        3）不要把字段和值颠倒写
            EXPLAIN SELECT ename FROM emp WHERE "3000"=sal; 
   （2）执行计划与耗时结合看  
   （3）索引需要定期维护，原因看上面的索引准则
   （4）分页优化
        1）搜索和排序字段建议建索引
            分页查询时建议加上含索引字段的排序，可提高查询效率
            EXPLAIN SELECT * FROM emp ORDER BY empno LIMIT 10,2  
    (5) 优化sql的步骤
        1）明确常用字段：经常查的，经常排序的，经常关联的
        2）选择在哪些字段加索引
        3）再判断过滤的量  
        如表：
           性别，姓名，收入，年龄，籍贯，职业                       
        收入，年龄加索引（姓名是字符串，不加索引（LIKE "%A%"））
        散列值，不建议建联合索引，连续值比如省市区建联合索引
    查看表字段的字符集：SHOW FULL COLUMNS FROM dept; 
    关联查询优化索引时，注意查看两表关联字段的字符集和字段类型是否一致，不一致索引将失效。   