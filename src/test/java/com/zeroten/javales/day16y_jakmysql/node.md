### 1.查看进程
    (1) 语法：ps [option]
        ax：列出终端相关的，如果想要列出所有进程需要配合使用
        u：列出用户相关的，通常配合ax和grep使用 // ps aux | grep ssh
        f：显示进程树，显示效果不佳，不建议使用  // ps auxf
        o：指定显示列 // ps ao pid,ppid
            1）常用命令：ps aux | grep 进程名
            2）查看进程的时候，本身这条命令也是一个进程
            3）ps查看的进程都是瞬时的快照(也就是只能查看查询进程那一瞬间的进程)
    (2) 语法：pstree [options] // 将进程以树状形式列出
        u：指定用户
        p：显示进程pid  // pstree -p 00442
        h：高亮显示当前进程及其相关
            注意：首先确保安装了psmisc  语法：yum install psmisc -y（mac用：brew install pstree）
### 2.进程的操作
    (1) 中断进程(正在运行)：ctrl+c
    (2) 杀死进程(后台运行)：使用kill命令  语法：kill[-信号][PID]
        选项                          说明
        s                       指定需要发送的信号，既可以是信号名(如：SIGKILL)，也可以是信号对应的号码(如：9)
        l                       显示信号名称列表。例如：kill -l
            kill -9 1024 // 用PID杀进程
            kill -9 %1  // 用任务编号杀进程
    (3) 退出前台：ctrl+z
    (4) 让某个进程进入后台执行：命令 &
### 3.任务（任务也属于进程）
    (1) 显示任务栏：jobs
        l       列出jobsnumber和PID
        r       列出在后台运行的工作
        s       列出在后台暂停(sleep)的工作  
    (2) 前后台转换    
        fg      转到前台执行  语法：fg %jobsnumber
        bg      转到后台执行
        ctrl+z  挂起当前任务
        ctrl+c  结束当前任务 
### 4.shell和shell script
    (1) shell：操作系统内核的
    (2) shell script：shell的脚本语言
        bash shell的变量
            查看变量：echo   例如：echo $PATH或echo "$name very cool"
            设置变量：=      例如：hs="Hello Shell" 
            取消变量：unset  例如：unset hs        
### 5.安装jdk
    (1) 卸载预安装的OpenJDK
        a.查询OpenJDK：rpm -qa|grep java
        b.删除OpenJDK：rpm -e --nodeps<OpenJDK版本> 
    (2) 安装JDK版本
        1) 安装LRZSZ：brew install lrasz
            lrzsz是secureCRT特有的
            mac还需要做如下配置才能使用rz,sz：https://github.com/izacklee/iterm2-zmodem
           上传文件：要上传的当前目录输入rz -> 选择文件上传
           下载文件：sz test.tar.gz -> 选择要下载到的目录下载  
        2) 安装gcc(c语言的运行库)：brew install gcc  
        3) 先卸载openjdk，注意rpm -qa|grep java列出的jdk都要卸载完！！！
        4) 解压jdk：tar -xzf jdk-8u162-linux-x64.tar.gz 
            改名：mv jdk1.8.0_162 java 
            将java文件夹移动到/usr/local（用户目录）目录下：mv java /usr/local
        5）配置环境变量： /etc/profile
           # 关于JAVA
           export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-9.0.4.jdk/Contents/Home
           export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
           export PATH=$PATH:$JAVA_HOME/bin
        6) 环境变量配置后，要刷新生效：source /etc/profile
### 安装mysql           
    (1) 安装mysql
        1) 解压mysql：tar -xzvf mysql-5.6.35-linux-glibc2.5-x86_64.tar.gz
            改名：mv mysql-5.6.35-linux-glibc2.5-x86_64 mysql
            将mysql移动到/usr/local目录下：mv mysql56 /usr/local
        2) 配置环境变量：/etc/profile
            # 关于MySql
            export MYSQL_HOME=/usr/local/mysql
            export PATH=$PATH:$MYSQL_HOME/bin   
        3) 环境变量配置后，要刷新生效：source /etc/profile
            查看mysql环境变量配置是否生效： mysql 
            （出现Can't connect to local MySQL server提示，说明环境变量已经配置好了，但是服务还没启动，mysql跑不起来）
        4) 创建用户组：groupadd mysql
        5) 将用户添加到用户组：useradd -g mysql mysql  
            // 以下命令切换到mysql目录下执行    
        6) 创建保存数据的目录：mkdir /data/mysql  
        7) 修改所属用户组用户(用户和用户组以及其所有子目录和文件)：sudo chown -R mysql:mysql ./
        8) 安装（指定mysql用户和数据地址）： 
            sudo rm -rf *          
            mac系统执行：sudo ./bin/mysql_install_db --user=mysql --datadir=/usr/local/mysql/data/mysql
            linux执行：./script/mysql_install_db --user=mysql --datadir=/usr/local/mysql/data/mysql
        9) 设置启动：sudo cp -R ./support-files/mysql.server /usr/local/bin/mysqld
            linux执行：cp ./support-files/mysql.server /etc/init.d/mysqld
        10) 分配访问权限：chmod -R 755 /usr/local/bin/mysqld    
            linux执行：chmod -R 755 /etc/init.d/mysqld
        11) 拷贝核心配置文件：cp ./support-files/my-default.cnf /etc/my.cnf 
        12) 修改启动脚本： /usr/local/bin/mysqld  (linux：/etc/init.d/mysqld) 
            a.修改项1：basedir=/usr/local/mysql
            b.修改项2：datadir=/usr/local/mysql/data/mysql
        13) 配置环境变量：export PATH=$PATH:/usr/local/mysql/bin
        14) 刷新环境变量：source /etc/profile
            // 以上步奏完成实际上mysql已经安装好了
        16) 启动mysql：sudo mysqld start （linux则用service执行，比如：service mysqld start）
            mysql操作：
                a.启动服务：sudo mysqld start  
                b.查看状态：sudo mysqld status 
                c.关闭服务：sudo mysqld stop  
        17) 给mysql设置密码：
             a.执行命令：mysql -uroot -p
             b.第一次进入mysql没有密码，直接回车进入       
                注意：如果提示ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: NO)
                解决方式：
                    a) 关闭mysql服务
                    b) 到/etc/my.cnf配置文件最后处，增加skip-grant-tables（跳过安全验证）
                    c) 重新启动mysql服务，再次尝试登录即可
              c.SHOW DATABASES; // 查看所有数据库列表
              d.USE mysql;  // 切换库
              e.SHOW TABLES; // 显示当前库所有的表
              // 查看用户的信息，注意！！！ mysql5.7版本的Password字段已经改成了authentication_string了
              f.SELECT Host, User, authentication_string FROM user;
              g.UPDATE user SET authentication_string=password('新密码') WHERE User='root'; // 修改密码
              h.flush privileges; // 刷新生效  
              i.quit; // 退出mysql重新a步奏，输入账号密码进入。
                (注：此时，可以把/etc/my.cnf配置文件中的skip-grant-tables去掉了)
        18) 授权：
            a.GRANT ALL PRIVILEGES ALL *.* TO 'root'@'%' IDENTIFID BY '123456' WITH GRANT OPTION;   
                (如果提示：You must reset your password using ALTER USER statement before executing this statement. 
                意思是你的数据库密码已过期了，此时需要设置下，修改为永不过期，执行语句：
                    ALTER USER 'root'@'localhost' IDENTIFIED BY 'root' PASSWORD EXPIRE NEVER;
                执行完，再执行授权即可。)
            b.flush privileges;  
        19) 关闭防火墙：
            mac系统：系统偏好设置->安全性与隐私->防火墙->关闭
            linux系统：
                关闭防火墙，先退出(quit)mysql
                以下是linux CentOS6关闭防火墙的命令，注意！！！CentOS的版本不同，关闭防火墙的命令可能不同，
                    比如CentOS7和CentOS6就不同。
                a.关闭命令：service iptables stop
                b.永久关闭防火墙：chkconfig iptables off
                c.查看防火墙关闭状态：service iptables status
                    在内网永久关闭防火墙，可以的。
    (2) 如果安装出错了：
        1) 删除mysql目录
        2）删除(mac)/usr/local/bin/mysqld； (linux)/etc/init.d/mysqld
        删除完之后就可以重装了                
                  
                     
                
       