package com.zeroten.javales.day06y_xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

// 修改XML文件
public class Demo03Writer {

    public static void main(String[] args) throws Exception {
        // 1.读文件
        SAXReader reader = new SAXReader();
        String path = Demo03Writer.class.getResource("/books.xml").getPath();
        Document document = reader.read(path);

        Element books = document.getRootElement();
        // 需要添加的列表
        List<Element> bookList = books.elements();

        // 修改 获取到了再改
//        Element element = bookList.get(0);

        Element newBook = DocumentHelper.createElement("book");
        newBook.addAttribute("id", "bk003");
        newBook.addCDATA("hello world");
        bookList.add(newBook); // 追加

        // 2.创建格式化
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        // 3.往外写
        OutputStream out = new FileOutputStream(new File(path));
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(document);
        writer.close();
        out.close();

    }
}
