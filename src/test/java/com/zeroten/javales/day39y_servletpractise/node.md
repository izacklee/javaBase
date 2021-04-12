#### 1.建库建表
    # 创建数据库
    CREATE DATABASE IF NOT EXISTS file_cloud CHARACTER SET utf8;
    # 删除数据库
    DROP DATABASE file_cloud;
    # 查看数据库列表
    SHOW DATABASES;
    # 查看指定数据库字符集
    SHOW CREATE DATABASE file_cloud;
    # 使用数据库
    USE file_cloud;
    # 查看当前数据库
    SELECT DATABASE();
    # 查看数据库所有表
    SHOW TABLES;
    # 删除表
    DROP TABLE IF EXISTS user;
    # 删除表字段
    ALTER TABLE file_history DROP update_time;
    
    # 创建用户表User
    # 注意语句须先写：UNSIGNED 必须写在NOT NULL前
    CREATE TABLE IF NOT EXISTS user(
    	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    	username varchar(20) NOT NULL COMMENT '用户名',
    	`password` varchar(100) NOT NULL COMMENT '密码',
    	realname varchar(20) COMMENT '真实姓名',
    	create_time datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
    	update_time datetime NOT NULL DEFAULT NOW() COMMENT '更新时间',
    	appid varchar(100) NOT NULL COMMENT '用户唯一标识'
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT '用户表';
    
    # 创建文件存储表file_cloud
    CREATE TABLE IF NOT EXISTS file_cloud (
    	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    	file_name varchar(100) NOT NULL COMMENT '文件名',
    	file_path varchar(500) NOT NULL COMMENT '文件路径',
    	file_type int(11) NOT NULL COMMENT '文件类型',
    	file_size int(11) NOT NULL COMMENT '文件大小',
    	file_status int(11) NOT NULL COMMENT '文件状态',
    	appid varchar(100) NOT NULL COMMENT '用户唯一标识',
    	create_time datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
    	update_time datetime NOT NULL DEFAULT NOW() COMMENT '更新时间'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文件存储表';
    
    # 创建文件历史记录表file_history
    CREATE TABLE IF NOT EXISTS file_history (
    	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    	file_name varchar(100) NOT NULL COMMENT '文件名',
    	file_path varchar(500) NOT NULL COMMENT '文件路径',
    	file_type int(11) NOT NULL COMMENT '文件类型',
    	file_size int(11) NOT NULL COMMENT '文件大小',
    	history_status int(11) NOT NULL COMMENT '历史状态',
    	appid varchar(100) NOT NULL COMMENT '用户唯一标识',
    	create_time datetime NOT NULL DEFAULT NOW() COMMENT '创建时间'
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT '文件历史记录表';
    
    # 用户容量表user_volume
    CREATE TABLE IF NOT EXISTS user_volume (
    	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    	size int(11) NOT NULL DEFAULT 0 COMMENT '容量大小',
    	def_size int(11) NOT NULL DEFAULT 52428800 COMMENT '当前容量值',
    	max_size int(11) NOT NULL DEFAULT 52428800 COMMENT '最大容量值',
    	expire_time datetime NOT NULL DEFAULT NOW() COMMENT '有效期',
    	appid varchar(100) NOT NULL COMMENT '用户唯一标识'
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT '用户容量表';
    
#### 2.用户注册
   （1）初始化容量
   （2）生成APPID，在系统内部流通（token用于外部流通）
   （3）初始化用户的文件系统根目录
    用户登录
    共享sessionID
    缓存：Zookeeper