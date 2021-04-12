package com.m.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/t3")
public class TestController3 {
    
    @RequestMapping("/upload")
    public String upload(@RequestParam("upload") MultipartFile file) throws IOException {

//        file.getInputStream() // 可手动获取输入流（字节拷贝） 如果不需要的话不推荐这么做

        System.out.println("原文件名：" + file.getOriginalFilename());

        // 上传到什么地方 --- 这个效率高
        file.transferTo(new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "slsweb/src/com/jinxun/githubmaven/java_demo/src/test/java/com/zeroten/" +
                "javales/day46y_springmvc/web/test/src/main/java/com/m",
                new Date().getTime() + file.getOriginalFilename()));

        return "jsp/upload";

    }

    // json
    @ResponseBody // json格式输出要加
    @RequestMapping("/json1")
    public Object json1() throws Exception{

        Map m = new HashMap();
        m.put("id", "1");
        m.put("name", "Zack");
        m.put("age", "18");

        return m;
    }
}
