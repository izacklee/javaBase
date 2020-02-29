package com.zeroten.javales.day06y_xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

// 读XML文件
public class Demo01Reader {

    public static void main(String[] args) throws Exception {
        /*
        // 获取地址
        // /Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/
        // src/test/java/com/zeroten/javales/day06y_xml/books.xml
//        System.out.println(new File("src/test/java/com/zeroten/javales/day06y_xml" +
//                "/books.xml").getCanonicalPath());

        // /Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo
//        System.out.println(System.getProperty("user.dir"));

        // /Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/
        // target/test-classes:/Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/
        // githubmaven/java_demo/target/classes:/Users/app/.m2/repository/org/testng/testng/7.0.0/
        // testng-7.0.0.jar:/Users/app/.m2/repository/com/beust/jcommander/1.72/jcommander-1.72.jar:/Users/
        // app/.m2/repository/dom4j/dom4j/1.6.1/dom4j-1.6.1.jar:/Users/app/.m2/repository/
        // xml-apis/xml-apis/1.0.b2/xml-apis-1.0.b2.jar
//        System.out.println(System.getProperty("java.class.path"));

        // 1.从src往后找，如果找不到返回NullPointerException  ----选用
        String path = Demo01Reader.class.getResource("/books.xml").getPath();
        // 2.从src往后找，如果找不到返回NullPointerException  ---- 选用
        // 注：文件名前没有反斜杠
        String path2 = Demo01Reader.class.getClassLoader()
                .getResource("books.xml").getPath();
        // /Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/
        // java_demo/target/classes/books.xml
        System.out.println(path);
        // /Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/
        // java_demo/target/classes/books.xml
        System.out.println(path2);

        // 3.如何处理路径中的空格
        String domePath = "/4%20java";
        String newPath = domePath.replaceAll("%20"," ");
        System.out.println(domePath); // /4%20java
        System.out.println(newPath); // /4 java

        */

        // 开始解析
        // 1.获取解析器
        SAXReader reader = new SAXReader(); // 直接创建对象
        String path = Demo01Reader.class.getResource("/books.xml").getPath();
        // 2.获取文档
        Document document = reader.read(new FileInputStream(new File(path)));
//        System.out.println(document.getNodeType()); // 9
//        System.out.println(document.getNodeTypeName()); // Document

        // 读所有节点对象node--
        /* 处理node的伪代码
            for(Element node : nodeList) {
                switch(node.getType()) {
                    case 1:
                        element = node;
                        break;
                    case 2:
                        attr = node;
                        break;
                    case 3:
                        text = node;
                        break;
                }
            }

        * */

        // 3.获取根目录
        Element rootEle = document.getRootElement();
//        System.out.println(rootEle.getNodeType()); // 1
//        System.out.println(rootEle.getNodeTypeName()); // Element

        // 4.获取子元素
//        rootEle.element("book"); // 根据节点名获取第一个该名称的节点
//          rootEle.elements(); // 获取所有子标签
         List<Element> bookList = rootEle.elements("book"); // 获取该所有名称的子标签

        for(Element book : bookList) {
            // 根据属性名获取属性
//            System.out.println(book.attribute("id")); // [Attribute: name id value "bk101"]
            // 获取所有属性
//            System.out.println(book.attributes()); // [Attribute: name id value "bk101"]]

//            Attribute attr = book.attribute("id");
//            System.out.println(attr.getName()); // id
//            System.out.println(attr.getNodeType());  // 2
//            System.out.println(attr.getNodeTypeName()); // Attribute
//            System.out.println(attr.getValue()); // bk101

            // 获取指定属性名的属性值
            String id = book.attributeValue("id");
//            System.out.println(id); // bk101

            List<Element> bookChildEle = book.elements();
            // 继续获取所有子元素
            for(Element bc : bookChildEle) {
                System.out.println(bc.getName()); // 获取标签名
                // 遇到CDATA，也是正常读
                System.out.println(bc.getText()); // 获取文本内容
                System.out.println(bc.getTextTrim()); // 获取不带空格的文本内容
            }

        }

    }
}
