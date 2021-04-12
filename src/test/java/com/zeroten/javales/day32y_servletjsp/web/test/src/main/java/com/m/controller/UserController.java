package com.m.controller;

import com.m.controller.base.BaseServlet;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserController extends BaseController {
    
    public void insert() {
        
        System.out.println("insert");
    }
    
    public void update() {
        System.out.println("update");

    }
    
    public void delete() {
        System.out.println("delete");

    }

    public void ajax() {
        // 这是一个ajax请求
        // 设置响应头
        super.getHres().setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            // 获取响应输出流
            out = super.getHres().getWriter();
            out.write("{\"msg\":\"你好呀\"}");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }
    
    public void select() {
        List<String> list = Arrays.asList(new String[] {"aaa","bbb","ccc"});
        super.getHreq().setAttribute("list", list);
        try {
            super.getHreq().getRequestDispatcher("../jsp/demo05/list.jsp").forward(getHreq(),getHres());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
