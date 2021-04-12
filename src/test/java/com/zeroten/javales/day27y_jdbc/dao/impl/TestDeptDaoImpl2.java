package com.zeroten.javales.day27y_jdbc.dao.impl;

import com.zeroten.javales.day27y_jdbc.annt.Column;
import com.zeroten.javales.day27y_jdbc.annt.Table;
import com.zeroten.javales.day27y_jdbc.dao.TestDeptDao2;
import com.zeroten.javales.day27y_jdbc.dao.base.BaseDeptDao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    需求：写一个通用的查询，用泛型来设计
    分析：
        1.要知道我要查询的是那张表
        2.要知道我要查询的是哪些列
        3.如何映射（列-属性/表-对象）
        4.最终的查询结果，根据传入的参数动态查询
 */
public class TestDeptDaoImpl2 extends BaseDeptDao implements TestDeptDao2 {
    // 通用查询
    @Override
    public <T> List<T> query(T t) {
        List resultList = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            // 反射
            // 1 获取运行时的类
            Class<?> clazz= t.getClass();
            // 2 获取表名
            String tableName = "";
            Table table = clazz.getAnnotation(Table.class);
            // 如果加了注解，表名以注解当中的为准
            if (table != null) {
                tableName = table.value();
                // 如果加了注解，但是没给表名，空串，表名就是类名
                if ("".equals(tableName)){
                    tableName = clazz.getSimpleName(); // 获取基础类的简写名称 Dept
                }
            } else {
                // 如果不加注解，表名就是类名
//                tableName = clazz.getName(); // 得到class类的名称  com.zeroten.javales.day26y_jdbc.entity.Dept
                tableName = clazz.getSimpleName(); // 获取基础类的简写名称 Dept
            }
            // 3 获取列名
            // 列名不可能一样 所以用set集合
            Set<String> columnNames = new HashSet<>();
            // WHERE查询条件
            Map<String,String> wheres = new HashMap<>();

            // 获取所有属性并遍历
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Boolean isSelect = true;
                String condition = "=";
                String columnName = "";
                Column ca = f.getAnnotation(Column.class);
                if (ca != null) {
                    columnName = ca.value();
                    isSelect = ca.select();
                    condition = ca.condition();
                    if ("".equals(columnName)) columnName = f.getName();
                } else {
                    columnName = f.getName();
                }
                if (isSelect) { // 允许作为查询条件，才加入
                    columnNames.add(columnName);
                }
                // 获取该属性的get方法
                String getMethodName = "get" + String.valueOf(columnName.charAt(0)).toUpperCase() +
                        columnName.substring(1).toLowerCase();
                // getMethod的第二个参数类型类不需要传参，因为定义的实体类中get方法获取值不需要传参
                Method method = clazz.getMethod(getMethodName);
                Object value = method.invoke(t);
                // 有值再put
                if (value != null) {
                    wheres.put(columnName, condition); // 以列作为key，条件作为value存入条件map集合
                }
            }

            // 4 组装sql
            StringBuilder sql = new StringBuilder("SELECT ");
            for (String c : columnNames) {
                sql.append(c);
                sql.append(",");
            }
            String sqlStr =  sql.substring(0, sql.length() - 1);
            sql = new StringBuilder(sqlStr);
            sql.append(" FROM ");
            sql.append(tableName);
            sql.append(" WHERE 1=1 ");

            // 组装sql条件
            for (Map.Entry<String, String> m : wheres.entrySet()) {
                sql.append(" AND ");
                sql.append(m.getKey());
                sql.append(m.getValue());
                sql.append("?");
            }

            // 5 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            // 6 给占位符设置值
            int index = 0;
            for (Field f : fields) {
                String getMethodName = "get" + String.valueOf(f.getName().charAt(0)).toUpperCase()
                        + f.getName().substring(1).toLowerCase();
                Method method = clazz.getMethod(getMethodName);
                Object value = method.invoke(t);
                if (value != null) {
                    ps.setObject(++index, value);
                }
            }

            // 7 执行sql 查询结果
            ResultSet rs = ps.executeQuery();

            // 8 遍历结果集
            while (rs.next()) {
                Object o = clazz.newInstance();
                for (Field f : fields) {
                    boolean isSelect = true;
                    String columnName = "";
                    Column ca = f.getAnnotation(Column.class);
                    if (ca != null) {
                        columnName = ca.value();
                        isSelect = ca.select();
                        if ("".equals(columnName))  columnName = f.getName();
                    } else {
                        columnName = f.getName();
                    }
                    // 允许查询， 才获取值
                    if (isSelect) {
                        // 取值
                        Object value = rs.getObject(columnName);
                        if (value == null) continue;
                        // 设值
                        String setMethodName = "set" + String.valueOf(f.getName().charAt(0)).toUpperCase()
                                + f.getName().substring(1).toLowerCase();

                        // 这个f.getType类型==下面invoke的值value传入的类型
                        // 注意：这两类型必须相等，不等会抛异常
                        Method method = clazz.getMethod(setMethodName, f.getType());

                        if (Long.class.getName().equals(value.getClass().getName())) {
                            // 整型 Long->Integer
                            /*
                               f.getType().getConstructor(String.class).newInstance(value.toString());
                               f.getType()==Integer类型
                               构造里放String.class 后面才能传入value.toString()
                               然后最终返回的结果就是Integer类型了
                               其实返回什么类型 还是主要取决于前面的f.getType() 是什么类型
                               相当于如下写法:
                                    Long l = 22L;
                                    Object i = new Integer(l.toString());
                                    System.out.println(i.getClass()); // class java.lang.Integer
                             */
                            value = f.getType().getConstructor(String.class).newInstance(value.toString());
                        } else if (Date.class.getName().equals(value.getClass().getName())) {
                            // 时间  java.sql.date->java.util.date
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            value = sdf.parse(value.toString()); // parse方法解析字符串
                        } else if (Double.class.getName().equals(value.getClass().getName())) {
                            // 浮点型
                        } else if (String.class.getName().equals(value.getClass().getName())) {
                            // 字符串
                        }
                        method.invoke(o,value);
                    }

                }
                // 放入最终结果集
                resultList.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            super.closeConnection();
        }

        return resultList;
    }
    // 根据id查询
    @Override
    public <T> List<T> queryById(Integer id, Class<?> clazz) {
        List<T> resultList = new ArrayList<>();
        try {
            // 访问协议与获取连接
            Connection conn = super.getConnection();
            // 获取表名
            String tableName = clazz.getSimpleName();
            // 获取字段
            Field[] fields = clazz.getDeclaredFields();
            Set<String> columnNames = new HashSet<>();
            int index = 0;
            String columnId = "";
            for (Field f : fields) {
                Boolean isSelect = true;
                String columnName = "";
                Column ca = f.getAnnotation(Column.class);
                if (ca != null) {
                    isSelect = ca.select();
                    columnName = ca.value();
                    if ("".equals(columnName)) columnName = f.getName();
                } else {
                    columnName = f.getName();
                }
                // 将实体类的第一个字段默认为id
                if (++index == 1) columnId = columnName;
                if (isSelect) {
                    columnNames.add(columnName);
                }
            }
            // 组装sql
            StringBuilder sql = new StringBuilder("SELECT ");
            for (String c : columnNames) {
                sql.append(c);
                sql.append(",");
            }
            String sqlStr = sql.substring(0, sql.length() - 1);
            sql = new StringBuilder(sqlStr);
            sql.append(" FROM ");
            sql.append(tableName);
            sql.append(" WHERE ");
            sql.append(columnId);
            sql.append("=?");
            // 建立查询通道
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            // 给占位符填值
            ps.setObject(1, id);
            // 执行sql
            ResultSet rs = ps.executeQuery();
            // 遍历结果集
            while (rs.next()) {
                Object o = clazz.newInstance();
                for (Field f : fields) {
                    Boolean isSelect = true;
                    String columnName = "";
                    Column ca = f.getAnnotation(Column.class);
                    if (ca != null) {
                        isSelect = ca.select();
                        columnName = ca.value();
                        if ("".equals(columnName))
                            columnName = f.getName();
                    } else {
                      columnName = f.getName();
                    }
                    if (isSelect) {
                        // 获取值
                        Object value = rs.getObject(columnName);
                        // 获取set方法
                        String setMethodName = "set" + String.valueOf(columnName.charAt(0)).toUpperCase()
                                + columnName.substring(1).toLowerCase();
                        Method setMethod = clazz.getMethod(setMethodName, f.getType());

                        if (value == null) continue;
                        // 类型转换
                        if (Long.class.getName().equals(value.getClass().getName())) {
                            value = f.getType().getConstructor(String.class).newInstance(value.toString());
                        } else if (Date.class.getName().equals(value.getClass().getName())) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            value = sdf.parse(value.toString());
                        }
                        // 执行set方法设置值
                        setMethod.invoke(o, value);
                    }
                }

                resultList.add((T) o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            super.closeConnection();
        }

        return resultList;
    }

    @Override
    public <T> int insert(T t) {
        return 0;
    }

    @Override
    public <T> int insertList(List<T> ts) {
        return 0;
    }

    @Override
    public <T> int update(T t) {
        return 0;
    }

    @Override
    public <T> int deleteById(Integer id, Class<?> cla) {
        return 0;
    }
}
