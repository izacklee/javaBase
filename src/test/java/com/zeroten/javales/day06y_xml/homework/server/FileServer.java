package com.zeroten.javales.day06y_xml.homework.server;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.*;

/*
* 文件名称：server.FileServer
* 初始作者：ZackLee</br>
* 创建日期：2020/03/05 10:40</br>
* 功能说明：【】</br>
* =========================================</br>
* 修改记录：</br>
* 修改作者 日期 修改内容</br>
* =========================================</br>
* Copyright（c）2020-2021 .All rights reserved.</br>
* */
public class FileServer {

    private static FileServer fileServer;

    public static FileServer fileServerFunction() {
        if (fileServer == null) {
            synchronized(FileServer.class) {
                fileServer = new FileServer();
            }
        }
        return fileServer;
    }

    /*
     * 方法描述：[查询文件列表]</br>
     * 初始作者：ZackLee</br>
     * 创建时间：2020/03/05 11:50</br>
     * 创建版本：1.0.0</br>
     * =====================================</br>
     * 修改记录：</br>
     * 修改作者 日期 修改内容</br>
     * ======================================</br>
     *
     * @param pathName
     * @return java.util.List<java.io.File>
     *
     */
    public List<File> showFiles(String pathName) {
        File f = new File(pathName);
        return Arrays.asList(f.listFiles());
    }

    /*
    * 方法描述：[判断是文件还是目录]
    * 初始作者：ZackLee</br>
    * 创建日期：2020/03/05 14:02</br>
    * 开始版本：1.0.0</br>
    * =========================================</br>
    * 修改记录：</br>
    * 修改作者 日期 修改内容</br>
    * ==========================================</br>
    *
    * @param pathName
    * @return java.lang.Boolean
    */
    public Map<Boolean,File> fileOrMrk(String pathName) {
        // pathName为相对路径
        File f = new File(pathName);
        Map<Boolean, File> m = new HashMap<>();

        // 路径不存在
        if (!f.exists()) {
            throw new RuntimeException("File not found");
        }

        // 文件夹
        if (f.isDirectory()) {
            m.put(true, f);
            return m;
        }

        // 文件
        if (f.isFile()) {
            m.put(false, f);
            return m;
        }
        m.put(false, f);
        return m;
    }

    /*
    * 方法描述：[读取文件写到xml]
    * 初始作者：ZackLee</br>
    * 创建日期：2020/03/05 18:10</br>
    * 开始版本：1.0.0</br>
    * ===============================================</br>
    * 修改记录：</br>
    * 修改作者 日期 修改内容</br>
    * ===============================================</br>
    *
    * @param pathName
    * @return java.lang.boolean
    */
    public boolean readFileWrite(String pathName, Document doc, Element rb) {
        List<File> lists = this.showFiles(pathName);
        int i = 0;
        Document document;
        Element books;
        if (doc == null || rb ==null) {
            // 1.创建文档
            document = DocumentHelper.createDocument();
            books = document.addElement("books");
        } else {
            document = doc;
            books = rb;
        }
        while (i < lists.size()) {
            pathName = String.valueOf(lists.get(i));
            Map<Boolean, File> fileRes = this.fileOrMrk(pathName);
            Boolean b = (boolean) fileRes.keySet().toArray()[0];
            File f = (File) fileRes.values().toArray()[0];
            // 如果是文件夹
            if (b) {
                // 2.添加元素，添加属性
                Element book = books.addElement("book");
                Element name = book.addAttribute("name", f.getName());
                Element type = book.addAttribute("type", "1");
                Element size = book.addAttribute("size", String.valueOf(f.length()));

                this.readFileWrite(pathName, document, book); // 递归继续查找写入子级
            } else { // 如果是文件
                Element book = books.addElement("book");
                Element name = book.addAttribute("name",f.getName());
                Element type = book.addAttribute("type", "0");
                Element size = book.addAttribute("size", String.valueOf(f.length()));

                int indexOf = pathName.lastIndexOf(".");
                String extension = pathName.substring(indexOf);
                boolean txt = this.stringEquals(".txt", extension);
                // 只读取txt文件的内容
                if (txt) {
                    // 读取文件内容
                    StringBuffer sb = new StringBuffer();
                    Reader r = null;
                    try {
                        r = new InputStreamReader(
                                new FileInputStream(
                                        new File(pathName)));
                        int c = -1;
                        while ((c = r.read()) != -1) {
                            sb.append((char) c);
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (r != null) {
                            try {
                                r.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    book.addCDATA(sb.toString());
                }
            }
            ++i;
        }

        // 3. 创建格式化
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        // 4.往外写
        // 获取地址
        String path = FileServer.class.getResource(
                "/com/zeroten/javales/day06y_xml/homework").getPath();

        OutputStream out = null;
        XMLWriter writer = null;
        try {
            out = new FileOutputStream(new File(path, "file.xml"));
            writer = new XMLWriter(out, format);
            writer.write(document);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    /*
    * 方法描述：[判断扩展名是否符合要求]
    * 初始作者：ZackLee</br>
    * 创建日期：2020/03/05 20:10</br>
    * 创建版本：1.0.0</br>
    * ====================================</br>
    * 修改记录：</br>
    * 修改作者 日期 修改内容</br>
    * ====================================</br>
    *
    * @param a
    * @param b
    * @return java.lang.boolean
    *
    */
    public boolean stringEquals (String a, String b) {
        if (a == null || b == null) {
            return a==b;
        }
        return a.equals(b);
    }

    /*
     * 方法描述：[读取xml文件内容]
     * 初始作者：ZackLee</br>
     * 创建日期：2020/03/05 20:10</br>
     * 创建版本：1.0.0</br>
     * ====================================</br>
     * 修改记录：</br>
     * 修改作者 日期 修改内容</br>
     * ====================================</br>
     *
     * @param
     * @return void
     *
     */
    public void readXML() {
        // 1.获取解析器
        SAXReader reader = new SAXReader();
        String path = FileServer.class.getResource(
                "/com/zeroten/javales/day06y_xml/homework/file.xml").getPath();
        try {
            // 2.获取文档
            Document document = reader.read(new FileInputStream(new File(path)));

            // 3.获取根目录
            Element rootElement = document.getRootElement();
            List<Element> bookList = rootElement.elements("book");
            for (Element book : bookList) {
                String name = book.attributeValue("name");
                String type = book.attributeValue("type");
                String size = book.attributeValue("size");
                System.out.println(name + "->" + type + "->" + size);
                List<Element> bookChildEle = book.elements();
                for (Element bookChild : bookChildEle) {
                    name = bookChild.attributeValue("name");
                    type = bookChild.attributeValue("type");
                    size = bookChild.attributeValue("size");
                    System.out.println("***" + name + "->" + type + "->" + size);

                    List<Element> bookChildEle2 = bookChild.elements();
                    for (Element bookChild2 : bookChildEle2) {
                        name = bookChild2.attributeValue("name");
                        type = bookChild2.attributeValue("type");
                        size = bookChild2.attributeValue("size");
                        System.out.println("******" + name + "->" + type + "->" + size);

                    }
                }
                System.out.println("==============================");
            }



        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
