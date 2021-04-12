package com.m.controller;

import com.m.entity.User;
import com.m.entity.UserVolume;
import com.m.mvc.web.Controller;
import com.m.mvc.web.ModelMapping;
import com.m.mvc.web.MyRequestMapping;
import com.m.mvc.web.RequestParam;
import com.m.service.FileService;
import com.m.service.HDFSService;
import com.m.service.UserService;
import com.m.util.ZkUtil;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@MyRequestMapping("/fc")
public class FileController implements Controller {
    private FileService fileService;
    private UserService userService;
    private HDFSService hDFSService;

    @MyRequestMapping("/loginUser.do")
    public String loginUser(
            HttpSession session,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            ModelMapping map
    ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userService.queryUser(user);
        // 用户登录后，可以保证该用户再次登录的时候，不需要再输入用户名和密码
        /**
         * 1.假设，我把用户数据保存到mysql当中的一个临时表，那么这种情况下，
         *      是否可以解决sessionId无法共享的问题？
         *      答：1）可以解决，但是这种方式极大的增加数据库访问的压力。
         *         2）繁琐（需要访问service->访问dao->连接数据库->建表->维护等）
         * 2.假设，我们把用户的登录数据，保存到HDFS这样的文件系统当中，能否解决sessionId无法共享的问题？
         *      答：1）可以解决，但HDFS是保存大文件，PB（百亿亿字节）级别的数据才适用，而他的时效性无法得到保证（有时很慢）
         * 3.解决方案：我们希望有一种能够保存数据，且访问时效高，且不那么繁琐的一种中间件
         *      答：使用缓存中间件，比如：Zookeeper、MongoDB、redis
         *              zk(大项目)      vs             redis(小项目)
         *  吞吐量         略低                      略高（每秒亿级）
         *  可扩展性        高                           略低
         *  数据安全性       高                           略低
         *
         */
        session.setAttribute("user", user);

        ZkUtil.put(user.getAppid() + "_" + new Random().nextInt(1000), 
                String.valueOf(new Date().getTime())); // 每次请求抵达后，修改时间戳

        return "/index.jsp";
    }
    
    @MyRequestMapping("/registerUser.do")
    public String registerUser(
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("realname") String realname,
                        ModelMapping map
                        ) {

        // 这里应当已经做过用户名验重
        // UUID.randomUUID().toString(); // javaJDK提供的一个自动生成主键的方法
        
        String appid = username + "_" + UUID.randomUUID().toString();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRealname(realname);
        user.setAppid(appid);

        UserVolume userVolume = new UserVolume();
        userVolume.setAppid(appid);

        // 在注册成功后，同时需要添加用户的容量信息，并且添加用户hdfs的根目录
        int i1 = this.userService.insertUser(user);
        int i2 = this.userService.insertUserVolume(userVolume);
        boolean r = this.hDFSService.mkdir(appid);

        if (i1 == 1 && i2 == 1 && r) {
            map.add("message", "注册成功");
            return "redirect:/login.jsp";
        } else {
            map.add("message", "注册失败");
            return "redirect:/register.jsp";
        }
    }

    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public HDFSService getHDFSService() {
        return hDFSService;
    }

    public void setHDFSService(HDFSService hDFSService) {
        this.hDFSService = hDFSService;
    }
}
