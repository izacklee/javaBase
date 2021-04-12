#### 1.创建数据库表
    # 创建blog数据库
    CREATE DATABASE blog CHARACTER SET utf8;
    # 使用数据库
    USE blog;
    # 查看当前使用数据库
    SELECT DATABASE();
    # 查看所有数据库表
    SHOW TABLES;
    
    # 创建用户表users
    CREATE TABLE IF NOT EXISTS users (
    	id int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '用户id',
    	username varchar(20) NOT NULL COMMENT '用户名',
    	`password` varchar(40) NOT NULL COMMENT '密码',
    	age int(10) NOT NULL COMMENT '年龄',
    	sex int(10) NOT NULL DEFAULT 0 COMMENT '性别 0保密 1男 2女',
    	nickname varchar(20) NOT NULL COMMENT '昵称',
    	mobile varchar(15) NOT NULL COMMENT '手机号',
    	address varchar(50) NOT NULL COMMENT '地址',
    	supper int(10) NOT NULL DEFAULT 0 COMMENT '管理员 0非管理员 1管理员',
    	picpath varchar(100) NOT NULL COMMENT '头像名称'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户信息表';
    
    # 插入一条管理员数据
    INSERT INTO users (username, `password`, age, sex, nickname, mobile, address,
     supper, picpath)
    VALUES ('admin',MD5(123456), 28, 1, 'admin', 18511110000, '北京市海淀区', 1, '/images/');
    
    # 创建微博表blog 
    CREATE TABLE IF NOT EXISTS blog (
    	id int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '微博id',
    	content varchar(1000) NOT NULL COMMENT '内容',
    	publishtime datetime NOT NULL DEFAULT NOW() COMMENT '发布时间',
    	userid int(10) NOT NULL COMMENT '用户id'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '微博表';
    
    # 插入4条微博默认数据
    INSERT INTO blog (content, userid) VALUES 
    ('今天星期一',1),
    ('明天星期二',1),
    ('后天星期三',1),
    ('星期四了...',1);
    
    # 查看blog数据
    SELECT id, content, publishtime, userid FROM blog;
    # 修改blog的数据
    UPDATE blog SET content='星期四了...' WHERE id = 4;
    # 删除blog的数据
    DELETE FROM blog WHERE id = 5;