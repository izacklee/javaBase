package com.zeroten.javales.day67c_netty;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 习题：
 * 1 List<Student>过滤学号大于100的学生？
 */

public class Java8Test {

    @Data
    static class Student {

        /**
         * 学号
         */
        private Integer stdNo;

        /**
         * 年级
         */
        private Integer grade;

        /**
         * 年龄
         */
        private Integer age;

//        public Integer getStdNo() {
//            return stdNo;
//        }
//
//        public void setStdNo(Integer stdNo) {
//            this.stdNo = stdNo;
//        }
//
//        public Integer getGrade() {
//            return grade;
//        }
//
//        public void setGrade(Integer grade) {
//            this.grade = grade;
//        }
//
//        public Integer getAge() {
//            return age;
//        }
//
//        public void setAge(Integer age) {
//            this.age = age;
//        }
//
//        @Override
//        public String toString() {
//            return "Student{" +
//                    "stdNo=" + stdNo +
//                    ", grade=" + grade +
//                    ", age=" + age +
//                    '}';
//        }
    }

    public static List<Student> getStudents(Integer studentsNum) {

        List<Student> students = new ArrayList<>();

        Random random = new Random();

        Integer maxStdNo = 10000;
        Integer maxGrade = 6;


        for (int i=0; i<studentsNum; i++) {
            Student student = new Student();

            //  idea 使用lombok build项目报错 the method getXXX() is undefined for type xxx
            // 解决办法：检查编译模式，不能使用Eclipse，修改为Javac再次编译通过
            student.setStdNo(1+random.nextInt(maxStdNo));
            student.setGrade(1+random.nextInt(maxGrade));
            student.setAge(6+student.getGrade());

            students.add(student);
        }

        return students;

    }

    public static void calcTest() {

    }

    public static void main(String[] args) {

        List<Student> students = getStudents(1000);

        List<Student> ret = new ArrayList<>();

        for (int i=0; i<students.size(); i++) {

            // 把学号大于100的学生取出来
            if (students.get(i).getStdNo() > 100) {

                ret.add(students.get(i));
            }

        }

//        ret.forEach((e) -> System.out.println("常规操作："+ e.toString()));

        // java8
        // filter（还有map/flatMap/reduce） 流的中间操作 也就是可以继续写
        // 终止操作（collect/test/forEach）就不可以 截止了
        List<Student> result = students.stream().filter((s) -> s.getStdNo() > 100)
                                .filter((s) -> s.getGrade() > 5) // 取出是6年纪的学生
                                .collect(Collectors.toList());

        // 用流操作 挑选出大于12岁的学生 大于就返回true
        boolean b = students.stream().anyMatch((s) -> s.getAge() > 12);

        result.forEach((e) -> System.out.println("java8操作："+ e.toString()));
    }

}
