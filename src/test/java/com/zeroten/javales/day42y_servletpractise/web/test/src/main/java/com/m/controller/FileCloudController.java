package com.m.controller;

import com.m.entity.*;
import com.m.mvc.web.*;
import com.m.service.FileService;
import com.m.service.HDFSService;
import com.m.service.UserService;
import com.m.util.BaseUtil;
import com.m.util.ZkSession;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@MyRequestMapping("/fc")
public class FileCloudController implements Controller {
    private FileService fileService;
    private UserService userService;
    private HDFSService hDFSService;

//    @MyRequestMapping("/toIndexPage.do")
//    public String toIndexPage() {
//
//        // 用户信息：最快 1
//        // 容量信息：访问mysql，从mysql获取信息 3
//        // 当前用户的文件信息：访问hdfs 5
//        // 1+3+5=9
//
//        return null;
//    }

    // 统一的登录验证
    @ResponseBody
    @MyRequestMapping("/loginCheck.do")
    public Object loginCheck(@RequestParam(value="token") String token) {
        String tokenTime = ZkSession.get(token);

        // 验证时间
        // 刷新时间

        Map<String, Object> map = new HashMap<>();

        return map;
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @MyRequestMapping("/fileUpload.do")
    public Object fileUpload(@RequestParam(value="file") FileEntity file,
                             @RequestParam(value="token") String token,
                             @RequestParam(value="path") String path) {

        // 把文件上传到hdfs
        String appid = ZkSession.get(token + "/appid");
        path = "/".equals(path) ? "/" : "/" + path + "/";
        
        // 异步，将HDFS的上传行为变成一个不再耗时的行为（建个中间表记录上传任务状态 
        // 像百度网盘那样可以做单独的页面 做数据批次记录 便于失败时批处理删除或更改状态）
        boolean result = this.hDFSService.upload(file.getInput(),
                appid + path +file.getFilename());

        // 把文件保存到数据库
        int i = 0;
        if (result) {
            FileCloud fc = new FileCloud();
            fc.setFileName(file.getFilename());
            fc.setFilePath(appid + path +file.getFilename());
            fc.setFileType(BaseUtil.getFileType(file.getFilename()));
            fc.setFileSize(file.getLength());
            fc.setFileStatus(0);
            fc.setAppid(appid);
            i = this.fileService.insertFileCloud(fc);
            
            // 保存操作记录getFileType
            if (i == 1) {
                FileHistory fh = new FileHistory();
                fh.setFileName(file.getFilename());
                fh.setFilePath(appid + path +file.getFilename());
                fh.setAppid(appid);
                fh.setHistoryStatus(1);
                this.fileService.updateFileHistory(fh);
                fh.setFileSize(file.getLength());
                fh.setFileType(BaseUtil.getFileType(file.getFilename()));
                fh.setHistoryStatus(0);
                this.fileService.insertFileHistory(fh);
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("message", result && i == 1);

        return map;
    }

    /**
     * 文件下载
     * @param response
     */
    @MyRequestMapping("/fileDownload.do")
    public void fileDownload(HttpServletResponse response,
                             @RequestParam(value="token") String token,
                             @RequestParam(value="path") String path,
                             @RequestParam(value="fileName") String fileName) {
        // 把文件上传到hdfs
        String appid = ZkSession.get(token + "/appid");
        path = "/".equals(path) ? "/" : "/" + path + "/";

        try {
            // 设置文件名的编码方式，使得文件的名字能够正常安全的显示。
//            fileName = URLEncoder.encode(fileName, "UTF-8");

            // 设置响应头控制浏览器以下载的形式打开文件（告诉浏览器这是下载文件）
            response.setHeader("content-disposition",
                    "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream out = response.getOutputStream();
            this.hDFSService.download(out, appid + path + fileName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @ResponseBody
    @MyRequestMapping("/getUserMessage.do")
    public Object getUserMessage(@RequestParam(value = "token") String token) {

        String realName = ZkSession.get(token + "/realName");
        Map<String, Object> map = new HashMap<>();
        map.put("realName", realName);

        return map;
    }

    /**
     * 获取用户容量信息
     * @param token
     * @return
     */
    @ResponseBody
    @MyRequestMapping("/getUserVolume.do")
    public Object getUserVolume(@RequestParam(value = "token") String token) {

        String appid = ZkSession.get(token + "/appid");
        UserVolume userVolume = new UserVolume();
        userVolume.setAppid(appid);
        userVolume = userService.queryUserVolume(userVolume);
        Map<String, Object> map = new HashMap<>();
        map.put("maxSize", userVolume.getMaxSize() / 1024 / 1024);

        return map;
    }

    @ResponseBody
    @MyRequestMapping("/mkdir.do")
    public Object mkdir(@RequestParam(value = "token") String token,
                        @RequestParam(value = "dirName") String dirName,
                        @RequestParam(value = "path") String path) {

        String appid = ZkSession.get(token + "/appid");
        String newPath = appid + "/" + path + "/" + dirName;

        // 路径是否存在验证
        // ...

        boolean result = this.hDFSService.mkdir(newPath);
        Map<String, Object> map = new HashMap<>();
        map.put("message", result);
        return map;
    }
    
    @ResponseBody
    @MyRequestMapping("/getUserFiles.do")
    public Object getUserFiles(@RequestParam(value = "token") String token,
                                @RequestParam(value = "path") String path) {
        String appid = ZkSession.get(token + "/appid");
        String newPath = appid + "/" + ("/".equals(path) ? "" : path);
        List<FileItem> fileItems = hDFSService.ListFile(newPath);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "ok");
        map.put("fileItems", fileItems);

        return map;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @MyRequestMapping("/loginUser.do")
    public Object loginUser(
//            HttpServletRequest Request,
//            HttpServletResponse Response,
//            ModelMapping map,
            @RequestParam("username") String username,
            @RequestParam("password") String password
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
//        session.setAttribute("user", user);

        // 每次登录会生成一个新的session
        String token = user.getAppid() + "_" + new Random().nextInt(1000);
        ZkSession.put(token,
                String.valueOf(new Date().getTime())); // 每次请求抵达后，修改时间戳

        // 随便放信息
        ZkSession.put(token + "/realName", user.getRealname());
        ZkSession.put(token + "/username", user.getUsername());
        ZkSession.put(token + "/appid", user.getAppid());
        ZkSession.put(token + "/id", user.getId() + "");

//        map.add("token", token); // 将token交给前端

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);

        return map;
        
//        return map.toJson();
//        return "redirect:/index.jsp";
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param realname
     * @return
     */
    @ResponseBody
    @MyRequestMapping("/registerUser.do")
    public Object registerUser(
//                        ModelMapping map,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("realname") String realname
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
        int i1 = userService.insertUser(user);
        int i2 = userService.insertUserVolume(userVolume);
        boolean r = hDFSService.mkdir(appid);

        Map<String, Object> map = new HashMap<>();
//
        if (i1 == 1 && i2 == 1 && r) {
            map.put("message", "注册成功");
//            map.add("message", "注册成功");
//            return "redirect:/login.jsp";
        } else {
            map.put("message", "注册失败");
//            map.add("message", "注册失败");
//            return "redirect:/register.jsp";
        }

        
        return map;
        
//        return map.toJson();
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
