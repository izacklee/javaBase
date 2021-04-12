package com.m.controller;

import com.m.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/t2")
public class TestController2 {
    
    @RequestMapping("/test1")
    public void test1() {
        System.out.println("hello SpringMVC");
    }

    @RequestMapping("/test2")
    public void test2(Integer id, String name) {
        System.out.println(id);
        System.out.println(name);
    }

    @RequestMapping("/test3")
    public void test3(User user) {
        System.out.println(user);
    }

    @RequestMapping("/test4/{arg1}/{arg2}")
    public void test4(@PathVariable Integer arg1, @PathVariable String arg2) {
//        @PathVariable 提取路径中的注解

        System.out.println(arg1);
        System.out.println(arg2);
    }

//    value={"/get","/fetch"}  // 即/get或/fetch都会映射到该方法上
    @RequestMapping(value={"/test5","/get5"})
    public void test5(Integer id, @RequestParam(value = "username", required = false) String name) {
        System.out.println(id);
        System.out.println(name);
    }
    
    @RequestMapping(value = "/test6", method = {RequestMethod.POST, RequestMethod.GET})
    public void test6() {
        System.out.println("hello SpringMVC");
    }

    @RequestMapping(value = "/test7/t?")
    public void test7() {
        System.out.println("hello SpringMVC test7");
    }

    @RequestMapping(value = "/test8/t*")
    public void test8() {
        System.out.println("hello SpringMVC test8");
    }

    @RequestMapping(value = "/test9/t/*")
    public void test9() {
        System.out.println("hello SpringMVC test9");
    }

    @RequestMapping(value = "/test10/t/**/{arg1}")
    public void test10(@PathVariable String arg1) {
        System.out.println("hello SpringMVC test10：" + arg1);
    }
    
    @RequestMapping(value="/test11")
    public String test11(ModelMap map) {  // 返回值类型也可用ModelAndView 但一般用String
        System.out.println("test11");
        map.addAttribute("message", "hello springMVC");
        
//        return "jsp/index";
        return "forward:/jsp/index.jsp"; // 转发（注：会导致配置文件的前后缀无效） 与上等效
    }

    @RequestMapping(value="/test12")
    public String test12(ModelMap map) {  // 返回值类型也可用ModelAndView 但一般用String
        System.out.println("test12");
        map.addAttribute("message", "hello springMVC");

        return "redirect:/t2/test11.do"; // 重定向
    }

}
