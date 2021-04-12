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

import java.util.UUID;

@MyRequestMapping("/fc")
public class FileController implements Controller {
    private FileService fileService;
    private UserService userService;
    private HDFSService hDFSService;
    
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
