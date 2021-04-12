package com.m.controller;

import com.m.entity.Dept;
import com.m.service.DeptService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;

@Controller
@Scope("prototype")
@RequestMapping("/dept")
public class DeptController {

//    @Autowired  // 加了这个之后就会自动按照类型装配 可省去了写getter/setter
    @Resource  // 同上
    private DeptService service;
    
    @ResponseBody // json格式输出要加
    @RequestMapping("/list.do")
    public Object list() {
        return this.service.selectDept(null);
    }

    @ResponseBody
    @RequestMapping("/insert.do")
    public Object insert() {

        int i = 0;
        i = this.service.insertDepts(Arrays.asList(
                new Dept[] {
                    new Dept(100, "BJ100", "北京100"),
                            new Dept(101, "BJ101", "北京101"),
                            new Dept(102, "BJ102", "北京102"),
                            new Dept(103, "BJ103", "北京103"),
                            new Dept(104, "BJ104", "北京104")
                }
        ));

        return i;
    }
}
