package com.m.controller;

import com.m.mvc.web.*;
import com.m.service.BaseService;
import com.m.service.impl.BaseServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@MyRequestMapping("/base")
public class BaseController implements Controller {

//    private BaseService service = new BaseServiceImpl();  // 代码高耦合度
    private BaseService service;

    // 文件上传
    @MyRequestMapping("/fileUpload.do")
    public void fileUpload(HttpServletRequest request) {
        // 判断请求类型是否为MultipartContent
        if (ServletFileUpload.isMultipartContent(request)) {
            // 上传的基本设置1-8
            // 1 创建DiskFileItemFactory工厂类
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 2 设置工厂内存缓冲区大小，默认是1M
            factory.setSizeThreshold(1024 * 1024);
            // 3 设置工厂的临时文件目录：当上传文件的大小大于缓冲区大小时，将使用临时文件目录缓存上传的文件
            factory.setRepository(new File(
                    request.getSession().getServletContext().getRealPath("/"),
                    "temp" + new Random().nextInt(100)));
            // 4 创建解析类，用于解析request
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 6 设置上传数据的最大值，单位字节long 5M
            upload.setSizeMax(1024 * 1024 * 5);
            // 7 设置单个文件上传的最大值
            upload.setFileSizeMax(1024 * 1024 * 5);
            // 8 设置编码格式
            upload.setHeaderEncoding("UTF-8");

            try {
                // 9 解析内容，获取一个list，数据都存储在list中
                //   这个list当中是保存所有的数据（还会保存文件以外的表单内容）
                List<FileItem> list = upload.parseRequest(request);
                // 10 遍历解析
                for (FileItem item : list) {
                    if (item.isFormField()) {
                        // 非文件表单内容
                        System.out.println("表单属性名：" + item.getFieldName());
                        System.out.println("表单属性值：" + item.getString());
                    } else {
                        // 文件表单内容
                        System.out.println("请求类型：" + item.getContentType());
                        System.out.println("文件名：" + item.getName());
                        // 文件输入流
                        InputStream ism = item.getInputStream();
                    }
                }
                
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    @MyRequestMapping("/test1.do")
    public String test1(@RequestParam("name") String str, @RequestParam("id") Integer id, HttpServletRequest hreq, HttpServletResponse hres,
                        ModelMapping mapping) {
        System.out.println("controller1被调用");
        service.test();

        mapping.add("key1","value1");
        mapping.add("key2","value2");
        mapping.add("key3","value3");

        return "/jsp/index.jsp";
//        return "forward:/jsp/index.jsp";
//        return "redirect:/jsp/index.jsp";
    }

    @ResponseBody
    @MyRequestMapping("/test2.do")
    public Object test2(String str, Integer id, HttpServletRequest hreq, HttpServletResponse hres) {
        System.out.println("controller2被调用");
        Map<String,Object> map =  new HashMap<>();
        map.put("username","Zack");
        map.put("password","123456");

        // json 数据类型，只有数值和字符串两种
        // 数组、集合、列表[{"username":"Zack"},{"password":"123456"}]
        // 对象Person:name,age,sex --> json:{"name":"Zack","age":1, "sex":1}
        // 对象{"password":"123456"}

        return map;
    }

    @MyRequestMapping("/test3.do")
    public void test3(String str, Integer id, HttpServletRequest hreq, HttpServletResponse hres) {
        System.out.println("controller3被调用");
        service.test();
    }

    public BaseService getService() {
        return service;
    }

    public void setService(BaseService service) {
        this.service = service;
    }
}
