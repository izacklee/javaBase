### 1.说明
    (1)INNODB必须有主键
        1) 设置自增主键，写入顺序是自增的，和B+树叶子节点分裂顺序一致，效率最高
        2) 可以不设置自增主键，不设置INNODB会自动生成一个ROW_ID作为主键
    (2)MyISAM支持主键，但是可以没有
    (3) 主键最好是自增长序列，不要是散列值
### 2.DML
    (1)增
        1）语法：INSERT INTO 表名 [(字段1, 字段2, 字段3...)] VALUES (值1, 值2, 值3...);
        2）注意：
            a.如果表设置了自增长，插入可以不给主键，如果给了主键，就按主键的值插入
            b.如果主键存在，则不能插入
            c.插入的语句当中可以不指定字段名，那么就相当于列出了所有的字段，顺序按照建表字段的顺序
        练习：
            #查看dept表结构
            DESC dept;
            # 查询部门表的数据
            SELECT deptno, dname, loc FROM dept;
            # 如果主键自增长，可以不比指定主键 单条数据插入
            INSERT INTO dept (dname, loc) VALUES ('TECHNOLOGY','GEIJING');
            # 多条数据插入
            INSERT INTO dept (dname, loc) 
            VALUES 
            ('TECHNOLOGY6','BEIJING'),
            ('TECHNOLOGY7','BEIJING');
            # 把查询的数据作为值，插入到另一张表
            # 注：查询字段和插入字段必须一致
            INSERT INTO dept (dname, loc) SELECT dname, loc FROM dept_auxiliary;
            # 不指定字段插入数据 按建表字段的顺序
            INSERT INTO dept_auxiliary SELECT dname, loc FROM dept;
            SELECT dname, loc FROM dept_auxiliary;
    (2)改
        1) 语法：UPDATE 表名 SET 字段1 = 值1, 字段2 = 值2, 字段3 = 值3, ... [WHERE 条件];
        练习：
            SELECT deptno, dname, loc FROM dept;
            SELECT dname, loc FROM dept_auxiliary;
            # 修改detp_auxiliary表的dname loc字段 不加where
            UPDATE dept_auxiliary SET dname='TECHNOLOGY', loc='BEIJING';
            # 加where的修改语句
            UPDATE dept SET dname='TECHNOLOGY', loc='BEIJING' WHERE deptno=106;
            # deptno BETWEEN 100 AND 105 实际上等于 deptno >= 100 AND deptno <= 105
            UPDATE dept SET dname='SALES', loc='SHANGHAI' WHERE deptno BETWEEN 100 AND 105;
            # 增加v字段
            ALTER TABLE dept ADD v int(11) DEFAULT 1 NOT NULL COMMENT '数据版本号';
            ALTER TABLE dept DROP v; # 删除v字段
            DESC dept; # 查看表结构
            SELECT deptno, dname, loc, v FROM dept;
            # 数据版本号的使用（加事务就不需要版本号了，事务本身是同步的，必然有排他性）
            # a
            UPDATE dept SET dname='SALES', loc='SHANGHAI', v=v+1 WHERE deptno=106 AND v=1; 
            # b
            UPDATE dept SET dname='SALES2',loc='SHANGHAI2',v=v+1 WHERE deptno=106 AND v=1; 	
    (3)删 
        1）语法：DELETE FROM 表名 [WHERE condition];
        2) 不加WHERE，即删除全表数据 
        3) 不使用外键约束的最主要的一个问题之一，就是有可能使用逻辑删除，数据没真删除，本来一对一的关系，有可能出现一对多
        4) TRUNCATE和DELETE都只删除数据，不删除表结构，TRUNCATE更快（TRUNCATE不建议用）
        5) TEUNCATE和DELETE区别，TRUNCATE会重置AUTO_INCREMENT，并不会触发事务
        6) TRUNCATE比DELETE快，因为TRUNCATE是DDL（相当于先DROP TABLE再CREATE TABLE），不用ROLLBACK，
            而DELETE是DML，要需要标记ROLLBACK
        7) 逻辑删除，只是修改数据删除的标识   
        练习：
            INSERT INTO emp (ename, job, mgr, hiredate, sal, comm, deptno) 
            VALUES ('SMITH2','CLERK2',79022,'1980-12-17', 802.00, null, 102),
            ('SMITH3','CLERK3',79023,'1980-12-17', 803.00, null, 103);
            # 删除全表
            DELETE FROM dept_auxiliary;
            # 增加del字段
            ALTER TABLE dept ADD del int(11) DEFAULT 0 NOT NULL COMMENT '删除标记 0未删除 1已删除';
            # 逻辑删除 假删 增量表（数据不会减，只会增）
            # 使用外键约束，逻辑删除没真删，本来是一对一的关系，有可能出现一对多的关系
            UPDATE dept SET del=1 WHERE deptno=106 AND del=0;
            # 物理删除 真删
            # emp表存在外键与dept表的deptno字段关联，如果deptno字段两表都存在相同的数据值，那么dept删除将失败，
            # 必须先删除emp表数据，dept才能删除（这也是不建议使用外键约束的一个原因）
            DELETE FROM emp WHERE deptno=103;
            DELETE FROM dept WHERE deptno=103;  
            
            DESC dept_auxiliary;
            # 添加索引
            ALTER TABLE dept_auxiliary ADD INDEX inxdname (dname);
            # 删除索引
            ALTER TABLE dept_auxiliary DROP INDEX inxdname;
            # 将查询的结果，插入到另一张表
            INSERT INTO dept_auxiliary SELECT dname, loc FROM dept;
            # TRUNCATE删除
            TRUNCATE TABLE dept_auxiliary;
            DELETE FROM dept_auxiliary;
    (4)查询
        1) 语法：SELECT [ALL|DISTINCT]
                {*|table.*|[table.field1[as alias1][,table.field2[as alias2]][,...]]}
                FROM table_name [as table_alias]
                [left|out|inner join table_name2] # 联合查询
                [WHERE ...] # 指定结果需要满足的条件
                [GROUP BY ...] # 指定结果按照哪几个字段来分组
                [HAVING ...] # 过滤分组的记录必须满足的次要条件
                [ORDER BY ...] # 指定查询记录按照一个或多个字段进行排序
                [LIMIT {[offset,]row_count | row_count OFFSET offset }] # 指定查询记录从哪条到哪条
                注释：[]代表可选的；{}代表必须的；# MySQL中的注释符，也可以用/* 注释内容 */
        2) 要求大家，每天至少完成50条不同类型的查询(百度搜：scott库练习题或把mysql函数都练一遍)，练满1000条查询，
           练到一个查询业务，看到脑海当中就能立刻反应出相关的数据结构，查询是你们永远安身立命的本钱，
           上课讲的是必须必须必须掌握的，一丁点都不能打折扣(数据库博大精深，单独学都能学上一年)。
           在面试当中，如果你的SQL题错了，一定PASS！！！。如果你想当项目经理，第一步就是SQL要好。
        3) 查询采用*代表所有列，不建议使用，影响查询性能
        4) 别名：as（可省略）
        5）DISTINCT去重：某几行当中，所有列的数据都相同，才可以去重
        6）表达式：如SELECT 1^1;
        7) NULL：不是0，也不是字符串的""，就是NULL
        8) LIKE 如果以通配符%开头，则当前列的索引失效，如果是匹配的字符串开头，则索引依然有效
        9) 不建议用子查询，实际开发中，性能很差，因为光sql就要解析两次
        10) 索引不建议加到字符串
        练习：
            SELECT * FROM dept;
            SELECT * FROM dept_auxiliary;
            # 查询所有员工信息
            SELECT * FROM emp;
            # 用AS子句作为别名 别名不要加引号，如：'maxSal'，可能有些框架不支持
            SELECT e.empno, MAX(e.sal) AS maxSal FROM emp AS e;
            # 别名也可以用中文
            SELECT empno, MAX(sal) 最大工资 FROM emp;
            # 去除重复 多个字段都相同才能去重
            SELECT DISTINCT deptno, job FROM emp;
            # 表达式（不写表可以测试，也可以带入到表中）
            # 不写表 （不属于任何库 练习用）
            SELECT 'Zack';
            SELECT 'Zack' 名字;
            # 写表 &&等同与AND
            SELECT *, 2*3 乘积, NULL FROM emp WHERE deptno=20 && mgr=7902;
            # 逻辑异或 XOR或^ 不同为真 相同为假
            SELECT 1 XOR 0; # 1
            SELECT 1 ^ 1; # 0
            SELECT 5/2;
            # 比较NULL
            SELECT * FROM emp WHERE comm IS NULL;
            SELECT * FROM emp WHERE comm IS NOT NULL;
            # 范围查询
            SELECT * FROM emp WHERE sal BETWEEN 1500 AND 3000;
            # sal>=1500 AND sal<=3000等同于sal BETWEEN 1500 AND 3000
            # 平时建议使用前者，因后者在某些特定的情况下，会导致索引失效，而前者就比较好控制
            SELECT * FROM emp WHERE sal >=1500 AND sal<=3000;
            # IN 取散列值 可用索引
            SELECT * FROM emp WHERE deptno IN (10,20);
            # NOT IN 不可用索引
            SELECT empno, deptno FROM emp WHERE deptno NOT IN (10,20);
            # 模糊匹配 字符串区分大小写 可在my.cnf配置文件更改lower_case_table_names实现
            SELECT * FROM emp WHERE ename LIKE 'A%'; # 查姓名为A开头的员工信息 不是以%通配符开头的，索引有效
            SELECT * FROM emp WHERE ename LIKE '_A%'; # 查姓名第二个字母为A的员工信息
            SELECT * FROM emp WHERE ename LIKE '%R%'; # 查询姓名包含R的员工信息 以通配符%开头，索引无效
            SELECT * FROM emp WHERE ename = 'ward';
            # 子查询 子查询语句可看做一个临时视图
            SELECT deptno, sal FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');
            # 创建视图 永久视图 
            CREATE VIEW empview AS SELECT * FROM emp;
            # 视图使用
            SELECT * FROM empview;
    (5)WHERE:
        1) 如果在修改的时候不加WHERE，那么就是对整张表进行修改
        2) 一般来说在修改的时候，where条件要指定索引的列，通常是主键
        3) 主键通常自带索引
        4) 外键通常自带索引
        5) 慎重使用：<>,!=，not in, not like, !>, !<因为不等号会导致索引失效，从而全文检索
        6) OR在使用的时候，如果左右两边，有一边没索引，则两边索引都失效
        7) 尽可能不要使用恒等式，如：WHERE 1 = 1 或 6 > 5等，因为没有索引，一定是全文检索
           (会导致所有的查询都携带该恒等式)                 