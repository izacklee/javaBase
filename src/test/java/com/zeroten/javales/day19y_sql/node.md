### 1.关联查询
    (1) 内联（=(等值最快), > ...(其次 范围扫描), !=(最慢 全表扫描)） 三者比较都是有索引的情况下
        内联是两张表都有的，才显示，两张表的交集
        1）等值内联（必须掌握）：INNER JOIN
            # 复制表 包含结构和数据 不能复制主键、索引和外键约束
            CREATE TABLE dept3 AS SELECT * FROM DEPT;
            CREATE TABLE emp_bak SELECT * FROM emp;
            # 复制表 只复制表结构不复制数据 可以复制主键、索引，但不能复制外键约束
            CREATE TABLE dept4 LIKE dept;
            CREATE TABLE emp2 LIKE emp;
            # 查看所有数据库
            SHOW DATABASES;
            # 使用数据库
            USE test;
            # 查看所有的表
            SHOW TABLES;
            
            SELECT * FROM dept;
            SELECT * FROM emp;
            
            # 禁用事务自动提交 目的用于回滚数据
            SET autocommit = 0;
            # 外键约束
            DELETE FROM dept WHERE deptno = 20;
            # 事务回滚
            ROLLBACK;
            # 删除表
            DROP TABLE IF EXISTS emp_copy;
            
            INSERT INTO emp2 SELECT * FROM emp;
            ALTER TABLE emp2 DROP FOREIGN KEY emp_dept_no;
            
            # 等值内联 不存在主表和从表
            SELECT 
            e.ename,
            d.dname
            FROM
            emp e INNER JOIN dept d
            ON
            e.deptno = d.deptno;
            # 等值内联可以简写 推荐写法
            SELECT 
            e.ename,
            d.dname
            FROM
            emp e, dept d
            WHERE 
            e.deptno = d.deptno;
        2）不等值内联：也叫自然连接，会产生笛卡尔乘积
            # 不等值内联简写 笛卡尔乘积 emp * dept 两表的每一条数据，都与对方的任意一条数据有关联
            SELECT 
            *
            FROM 
            emp, dept;
            # 或
            SELECT 
            e.ename,
            d.dname
            FROM
            emp e, dept d
            WHERE 
            e.deptno != d.deptno;
        3）自连接（必须掌握）：自己和自己关联
            # 自连接
            # 查出所有员工及其上级的姓名
            SELECT 
            e1.ename,
            e2.ename as mgrname
            FROM
            emp e1, emp e2
            WHERE 
            e1.mgr = e2.empno  # 意思是e2查的是e1的上级
    (2) 外联
        外联是主表有的都显示，从表没有的显示NULL，两张表的并集
        1）左外联：左边为主表，主表有的，全部显示，从表没有的显示NULL
            # 左外联 以左作为主表 右表作为从表
            # 查出所有员工及其上级的姓名，包含老板
            SELECT
            e1.ename,
            e2.ename as mrgname
            FROM
            emp e1 LEFT JOIN 
            emp e2
            ON e1.mgr=e2.empno;
            SELECT 
            e.*,
            d.*
            FROM
            emp e LEFT JOIN
            dept d 
            ON e.deptno=d.deptno;
        2）右外联：右边为主表，主表有的，全部显示，从表没有的显示NULL
            # 右外联
            SELECT
            e.*,
            d.* 
            FROM
            emp e RIGHT JOIN
            dept d
            ON e.deptno=d.deptno;
        3）全外联（FULL JOIN MySQL不支持）：两张表有的都显示 全外联结很多数据库不支持，
            SQLite不支持，access、MariaDB、MySQL、Open Office Base也都不支持
    (3) 自然连接：就是不等值内联
    (4) 交叉连接
        # 交叉联 CROSS JOIN 显式; 隐式为简写 和不等值内联简写一致 隐式写法没有CROSS JOIN
        SELECT 
        e.*,
        d.*
        FROM
        emp e CROSS JOIN
        dept d
        ON e.deptno=d.deptno;
### 2.外键约束 （不建议使用）
    (1) 标明外键：可以通过主观判断外键
    (2) 提供约束：外键可以有（字段可以建，一样用），但不要建约束，约束会使业务变得复杂
        （emp建立与dept外键约束，如果两表约束字段存在相同的数据，则必须先删除emp表的数据，才能删除dept表的数据
         emp添加数据时，约束的字段的值dept里没有，不能添加）
    (3) 补充说明
        1）主键和外键默认是自带索引
        2）但是通常情况下，多表关联，主表的主键索引生效，从表的主键索引是不生效的（一定是全表扫描）     
    (4) 排序
        1) 关键字：ORDER BY  
        2) 默认升序（ASC可以省略），可以倒序（显式写DESC） 
        3) 建议在经常排序的字段上加索引 
        # 排序
        # 有条件
        SELECT * FROM emp WHERE 1=1 ORDER BY empno DESC; 
        # 无条件
        SELECT * FROM emp ORDER BY empno ASC;
        # 多条件排序
        # 各个部门的员工工资升序排序
        SELECT deptno, empno, ename, sal FROM emp ORDER BY deptno, sal;
        SELECT deptno, sal FROM emp ORDER BY deptno DESC, sal ASC;
    (5) 分页  
        1) 语法：LIMIT index, offset
        2) index 从0开始，指索引
        3）offset 偏移量，查几条
        4）计算index的公式：(pageNnumber - 1) * offset  
        # 分页 
        # 计算index索引的公式：(pageNumber - 1) * offset
        SELECT empno, ename FROM emp LIMIT 0, 2;  
    (6) 分组
        1) 关键字：GROUP BY
        2) 聚合函数：
            COUNT：总数
            SUM：总和
            MAX：最大
            MIN：最小
            AVG：平均 
        3) 注意：分组后的结果集计算的，应当是聚合后(使用集合函数计算)的结果集
        4) 注意：分组依然可以多条件分组
        5) 对分组结果集再过滤：
            a.语法：HAVING
            b.可以多条件
        练习：
            # 分组
            # 计算各个部门的（或按部门 工作分组）
            # 最大工资，最小工资，平均工资，人数，工资总和
            SELECT
            deptno,
            job,
            MAX(sal) 最大工资, MIN(sal) 最小工资, AVG(sal) 平均工资, count(1) 人数, SUM(sal) 工资总和 
            FROM
            emp
            GROUP BY deptno, job;
            # 计算平均工资大于2000和工资总和大于9000的部门
            # HAVING 对分组的结果集进行再过滤
            SELECT
            e.deptno, d.dname,
            AVG(sal) 平均工资,
            SUM(sal) 工资总和
            FROM
            emp e, dept d
            GROUP BY deptno HAVING 平均工资>2000 AND 工资总和>9000;	    
    (7) mysql的执行顺序：
        7) SELECT  
        8) DISTINCT <select_list>
        1) FROM  <left table>
        3) <join_type> JOIN <right_talbe>
        2) ON <join_condition>
        4) WHERE <where_condition>
        5) GROUP BY <group_by_list>
        6) HAVING <having_condition>
        9) ORDER BY <order_by_condition>
        10) LIMIT <limit_number> 
            7.1) from 对查询指定的表计算笛卡尔积
            7.2) on 按照 join_condition 过滤数据
            7.3) join 添加关联外部表数据
            7.4) where 按照where_condition过滤数据
            7.5) group by 进行分组操作
            7.6) having 按照having_condition过滤数据
            7.8) select 选择指定的列
            7.9) distinct 指定列去重
            7.10) order by 按照order_by_condition排序
            7.11) limit 取出指定记录量    
    (8) 子查询
        1) 当单条件的时候(> < >= <= != = like)，必须保证，一行一列，即只有一个值
        2) 当条件为多个的时候，一列多行，可以和in一起用
        练习：
            # 子查询
            # 找到工资比scott高的人
            # 思路：1 找到scott的工资 2 比较出工资比scott高的人
            SELECT ename, sal FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');
            # 找到工资和10部门一样的员工
            # 提示：多条件时，一些容易造成索引失效的，或者全文索引的尽量往WHERE排，
            # 查得快的离它最远，查得慢的离他最近，过滤最多的离他最远，过滤最少的离他最近
            SELECT deptno, ename, sal FROM emp WHERE deptno!=10 AND sal in (SELECT sal FROM emp WHERE deptno=10);
    (9) 临时视图（临时表） 
        1) 临时表必须起别名
        2）临时表的字段需要起别名
        练习：
            # 临时视图
            # 找到各个部门员工，工资比经理高的
            SELECT e.deptno, e.ename, e.sal, t.ename mname, t.msal FROM emp e, (SELECT sal msal, deptno, ename FROM emp WHERE job='MANAGER') t 
            WHERE e.deptno=t.deptno AND e.sal>t.msal;
            # 找到各个部门员工，工资比平均工资高的
            SELECT e.deptno, e.ename, e.sal, t.asal FROM emp e, (SELECT AVG(sal) asal, deptno FROM emp GROUP BY deptno) t
            WHERE e.deptno=t.deptno AND e.sal>asal;
    (10) mysql的函数(练习：搜"mysql函数"，找菜鸟教程或w3c)
        1) 字符串
        2) 数值
        3）时间
        4）逻辑
        练习：
            # --函数--
            # 拼接字符串
            SELECT CONCAT('%','A','%'); # %A%
            # 返回字符串的长度
            SELECT CHAR_LENGTH('1SQWQ1213Q'); # 10
            # 按指定分隔符拼接字符串
            SELECT CONCAT_WS(',','A','B','C'); # A,B,C
            # 格式化保留两位小数 最后一位四舍五入
            SELECT FORMAT('3.1415926',2); # 3.14
            # 取字符串左边的3位
            SELECT LEFT('www.baidu.com',3); # www
            # 转小写
            SELECT LOWER('ACB'); #abc
            # 转大写
            SELECT UPPER('Hello'); # HELLO
            # --数值--
            # 取绝对值
            SELECT ABS(-10); # 10
            # 取100以内的随机数
            SELECT FORMAT(RAND()*100,0);
            # --时间-- 时间可以直接比较 不需要格式化
            # 系统时间
            SELECT NOW(); # 2020-04-13 16:35:33
            SELECT DATE_FORMAT('2020-04-13 16:35:33','%Y/%m'); # 2020/04
            # 时间的增减计算
            SELECT DATE_ADD('2020-04-13 16:35:33', INTERVAL 1 MONTH); # 2020-05-13 16:35:33 加一个月
            SELECT DATE_SUB('2020-04-13 16:35:33', INTERVAL 2 MONTH); # 2020-02-13 16:35:33 减两个月
            SELECT DATE_FORMAT('2020-04-13 16:35:33','%Y/%m') - DATE_FORMAT('2010-04-13 16:35:33','%Y/%m'); # 10
            # --逻辑--
            # 加密
            SELECT PASSWORD('123456');
            SELECT MD5('111111');
            # IF
            SELECT sal + IF(comm IS NULL, 0, comm), empno FROM emp;
            
    做数据迁移的工具：sqoop        
                   
                   
                
                 
                      