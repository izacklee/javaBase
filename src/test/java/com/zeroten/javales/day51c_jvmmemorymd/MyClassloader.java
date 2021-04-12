package src.test.java.com.zeroten.javales.day51c_jvmmemorymd;

import java.io.*;

/**
 * 自定义类加载器
 */
public class MyClassloader extends ClassLoader {

    private String root;

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 获取类的二进制数据
     * @param className
     * @return
     */
    private byte[] loadClassData(String className) {
        // File.separatorChar 表明文件路径区分符，系统自动代替特殊字符，比直接用更具有通用性。
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while (( length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {
        MyClassloader classloader= new MyClassloader();
        classloader.setRoot("/Users/app/Downloads/javaproject/javatest/basic-code" +
                "/slsweb/src/com/jinxun/githubmaven/java_demo/target/test-classes");
        Class<?> testClass = null;
        try {
            testClass = classloader.loadClass("/src.test.java.com.zeroten.javales.day51c_jvmmemorymd/" +
                    "FatherSonClassTest");
            Object object = testClass.newInstance();

            // 双亲委派模型 （父类能加载到 不会用自己）
            System.out.println(object.getClass().getClassLoader()); // 实际用的是ApplicationLoader 双亲委派模型

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
