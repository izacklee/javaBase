package com.zeroten.javales.day06y_xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

// 写XML文件
public class Demo02Writer {

    public static void main(String[] args) {
        // 只管写
        // 1.创建文档 虚拟空文档
        Document document = DocumentHelper.createDocument();
        Element books = document.addElement("books");
        Element book = books.addElement("book");
        book.addAttribute("id", "bk001");
        book.addCDATA("test word1");

        Element book2 = books.addElement("book");
        book2.addAttribute("id", "bk002");
        book2.addCDATA("test word2");

        // 2.创建格式化
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        // 3.往外写
        String path = Demo02Writer.class.getResource("").getPath();
        OutputStream out = null;
        XMLWriter writer = null;
        try {
            out = new FileOutputStream(new File(path, "books1.xml"));
            writer = new XMLWriter(out, format);
            writer.write(document);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
