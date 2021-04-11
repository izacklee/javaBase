### 1.配置网络环境
    (1) cd /etc/sysconfig/network-scripts/
    (2) 找到ifcfg-eth0文件
    (3) 把网络配置文件里的内容，复制粘贴到你的ifcfg-eth0文件里
    (4) 根据实际情况修改
        1）IPADDR=192.168.10.101
        2) GATEWAY=192.168.10.2
        
### 2.基本命令
    mac得开启ssh(openssh-server)服务，才能使用ssh登录到本机linux
    开启方式：系统偏好设置 -> 共享 -> 把远程登录打勾 -> 设置允许访问(安全考虑) 完成
    测试是否打开，可在终端输入：ssh 127.0.0.1 出现确认继续连接提示，说明ssh开启成功。
    
    (1) Linux命令格式：
        command[option][argument]
        命令名称 选项(可选) 参数(可选)
        
        1) shutdown：
            a.命令选项：r h
            b.参数
            
            shutdown -r 1000 & // 等待1000分钟后关闭虚拟机 加&字符的作用是，避免在等待中妨碍继续操作(在后台运行)。
            shutdown -c // 取消等待
     (2) 用户与用户组
        用户组列表路径：/etc/group
        用户列表路径：/etc/passwd  
        (计算机里所有的数据都是用文件保存的)
        
        Mac系统用户与用户组操作：
            创建用户组：sudo dscl . -create /Groups/hadoop1 // 创建hadoop1用户组
            查看用户组列表：dscl . -list /Groups
            删除用户组：sudo dscl -delete /Groups/hadoop2
            查看所有用户组下拥有的用户：dscl . -list /Groups GroupMembership
          
            创建用户：sudo dscl . -create /Users/zookeeper1 UniqueID 888  // 创建zookeeper1用户 
            给用户设置密码：sudo dscl . -passwd /Users/zookeeper1 123456
            查看用户列表：dscl . -list /Users
            将指定用户添加到指定用户组：sudo dscl . -append /Groups/hadoop1 GroupMembership zookeeper1
            删除用户：sudo dscl . -delete /Users/zookeeper1   // 删除zookeeper1用户
      (3) 用户的切换
           1）su：超级管理员切换成普通用户一般情况下不需要密码，普通用户切换成超级管理员需要输入密码。
           2) sudo：临时获取用户权限，需要到/ect/sudoers下添加用户权限信息才能使用
           touch不能创建与文件夹同名的文件
      (4) Ls查看目录和文件
            相对路径和绝对路径
                ./ 代表当前目录
                ../ 代表上一级
            1) ls[选项][路径]：查看目录
            2）ll[路径]：以长信息显示所有指定路径非隐藏文件
                a 查看所有文件，包含隐藏文件
                l 以长信息显示文件
                al 包含了a和l的功能
                文件前加一个点，代表隐藏文件或目录
       (5) 修改文件权限，用户和用户组
            drwxr-xr-x 分割成四部分(10个字符) d rwx r-x r-x
                                 类型 用户权限 用户组权限 其他用户权限
                d/- 目录/文件
                - 无权限
                r 可读
                w 可写
                x 可执行
            1）用户用户组和权限只作用于普通用户，对超级管理员无效 
                chgrp 修改用户组
                chown 修改用户 (同时修改用户和用户组 chown -R username:groupname download)
                chmod 修改权限 
                    说明：
                        数字：-(0)、r(4)、w(2)、x(1)，
                            （例如：rwx=4+2+1=7,r-x=4+0+1=5,---=0+0+0=0）
                        符号：u(user)、g(group)、o(other)、a(all)
                            使用+(添加权限)、-(删除权限)、=(设置权限)
                            （例如：a=rwx即等同于777（用户、用户组、其他三者的权限）; 
                                  chmod a=rwx download、 chmod go-x download）
       (6) Linux的目录
            典型目录            可分享的            不可分享的
            不可改变的         /usr(软件存放处)     /etc(配置文件)
                              /opt(第三方软件)     /boot(开机与内核)
            可以改变的         /var/mail(邮件)      /var/run(程序相关)
                            /var/spool/news(新闻)  /var/lock(程序相关)
       (7) Linux目录的相关操作
            1) 处理目录
                切换目录        cd
                显示目录路径     pwd
                新建目录        mkdir
                删除目录        rmdir(只能删除空目录，含有子目录时不能删除，通常用rm) 
                    rm删除文件夹时要加r，否则有多层级文件夹，将删除失败。如：rm -r test 
                    边创建边赋权：mkdir -m 777 test8
                    创建多层级目录：mkdir -p ./hdfs/data
            2) 复制、删除和移动
                创建文件        touch
                复制            cp(夸服务器复制scp)
                    a.复制文件直接复制
                    b.复制目录的时候，需要递归复制所有子目录，用选项-R
                删除            rm
                    rm -fr test55 // 删除test55文件夹  f为忽略提示 r为递归 
                移动            mv   
                    删除带特殊字符的文件夹：rmdir -- -R // 删除-R文件夹
                    修改带特殊字符的文件夹名称：mv -i -- %C7%D0? 切图  // 将文件夹名“%C7%D0?”，修改为"切图"
                    
                    // 移动和更名 
                        (目录和文件可以直接移动，不需要递归(移动文件夹mv test77 test66)，
                        更名目录需要递归(更名文件夹mv -i test6 test66)) 
                    mv test4 test44 // 更名 把test4更名为test44
                    mv -i test* test8 // 使用*通配符，移动所有符合匹配的文件夹和文件
                    cp test4 ./../../test9  // 复制test4到上两级并改名为test9
                    cp -R test9 test6/test7/  // 复制文件不改名字(复制test9到test7目录下)  
                        // -R是递归复制目录及子目录下所有文件
                    // 相对路径，路径前无需加"/"杠，
                    // 绝对路径，路径前要加"/"杠。
                    cp -R test4 test6/test7/test4 
                    cp -R test4 /usr/local/download/test6/test7/test5   
       (8) 软连接
             软连接(类似windows的快捷键)，为解决多个目录存放同一个文件，浪费内存的问题。
             创建软连接：ln -s [源文件或目录] [目标文件或目录]  
                ln -s test1/test2/test3 testln   
                touch test1/test2/test3/testfile
                ls testln
             修改软连接：ln -snf [新的源文件或目录] [目标文件或目录]
                ln -snf test1/test2/test3/test4/test5 testln
             删除软连接：rm -rf testln  // 其实就是删除对应的文件夹   
       (9) 文件内容查询
            cat         由第一行开始显示内容(只能看不能改)
            tac         由最后一行开始显示内容(倒过来看)
            nl          显示，同时显示行号
            more        一页一页的显示内容
            less        类似more(less速度更快；退出时不会在shell展示，more会展示；
                                less看完了还能往回看，more不能，看完就完了)
            head        只看头部几行
            tail        只看尾部几行
                查看指定日期的日志文件内容：less testfile | grep '2018-12-24 09'
                clear  清屏
       (10) 文件打包压缩/解压
            语法：tar[选项][参数]
            仅打包，不压缩     tar -cvf /tmp/usr.tar /usr
            打包以gzip压缩     tar -czvf /tmp/usr.tar.gz /usr
            解压              tar -xzvf /tmp/usr.tar.gz 
                说明：
                    c       建立一个打包文件        f       给出文件名
                    x       解压缩                 z       压缩gzip（建包）
                    v       有提示信息
            a.打包不压缩，文件会变大，但是效率高一点
            b.打包压缩，文件变小，但是效率低一点   
       (11) 重定向
            命令         示例                说明
             >       echo abc > test       输出重定向到一个文件或设备，覆盖原来的文件内容
             >!      echo abc >! test      输出重定向到一个文件或设备，强制覆盖原来的文件内容
             >>      echo abc >> test      输出重定向到一个文件或设备，追加文件内容
                a.覆盖
                b.追加  ls -l >> file
       (12) 查找文件
            语法：find path -option [-print]
            场景                      说明
            find . -name *.c        将当前目录及子目录下所有的后缀名为.c的文件列出来
            find . -type f          将当前目录及子目录下所有一般的文件列出来（只查文件，不查目录）
            find . -ctime -20       将当前目录及子目录下所有最近20天更新的文件列出来  
       (13) 管道 可多个管道操作
            1) 管道是把左边的执行结果，作为右边的条件  
                find . -type f | less  // 通过管道将左边查找出的文件列表，作为下一个less的输入，方便浏览 
                // 将左边重定向的内容，以':'分割之后，取第1和第3位
                echo hello1:hello2:hello3 | cut -d ':' -f 1,3  // hello1:hello3 
                // 将查找出来匹配等于test8的，加上颜色显示
                ls -l | grep test8 -i --color=auto
                ls -l | grep test8 -c  // -c 计算查找到字符串的次数 i忽略大小写 n输出行号 v反向选择
                grep r file -a --color=auto // 将文件中所有含r的加上颜色展示
            
                
                
                    
                    
                           
               
                
         
        