package com.m.controller;

import com.m.mvc.web.*;
import com.m.service.BaseService;
import com.m.service.impl.BaseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@MyRequestMapping("/base")
public class BaseController implements Controller {

//    private BaseService service = new BaseServiceImpl();  // 代码高耦合度
    private BaseService service;

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
