package cn.itcast.day05.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
 练习：用户管理系统

 - 查询用户：将系统中保存的全部用户信息在控制台打印输出。
 - 添加用户：向系统中添加新的用户信息，如果添加的用户已经存在，给出提示信息。
 - 删除用户：输入用户名，进行删除操作，若输入的用户名不存在，给出提示信息。
 - 账号冻结：输入用户名，进行冻结操作，若输入的用户名不存在或者该用户已经被冻结，给出相应提示。
 - 账号解冻：输入用户名，进行解封操作，若输入的用户名不存在或者该用户状态正常，给出相应提示。
 - 退出系统：跳出循环，给出提示信息。
*/
public class Demo08UMSystemPractise {

    public static void main(String[] args) {
        // 初始化数据
        // 姓名数组
        String[] name = {"张三", "李四", "王五"};
        // 年龄数组
        int[] age = {20, 22, 25};
        // 状态数组
        String[] state = {"正常", "正常", "正常"};

        // 系统流程控制
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        do {
            // 输出初始化信息
            System.out.println("----------欢迎使用用户管理系统----------");
            System.out.println("1.查询用户");
            System.out.println("2.添加用户");
            System.out.println("3.删除用户");
            System.out.println("4.账户冻结");
            System.out.println("5.账户解冻");
            System.out.println("6.退出系统");
            System.out.print("请选择：");

            while (n != 6) {
                if (n ==0) { // n为0返回上一级菜单
                    n = -1;
                    break;
                }
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("执行查询用户信息");
                        System.out.println("----------用户信息列表----------");
                        System.out.print("编号\t\t");
                        System.out.print("姓名\t\t");
                        System.out.print("年龄\t\t");
                        System.out.println("状态");
                        userList(name, age, state);
                        System.out.print("输入0返回上级菜单：");
                        n = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("执行添加用户信息");

                        System.out.print("请输入添加用户的姓名：");
                        String newName = scanner.next();
                        System.out.print("请输入添加用户的年龄：");
                        int newAge = scanner.nextInt();
                        int index = userIndex(name, newName);
                        // 用户不存在才添加
                        if (index == -1) {
                            String[] nameArr = Arrays.copyOf(name, name.length + 1);
                            nameArr[nameArr.length - 1] = newName;
                            name = nameArr;
                            int[] ageArr = Arrays.copyOf(age, age.length + 1);
                            ageArr[ageArr.length - 1] = newAge;
                            age = ageArr;
                            String[] stateArr = Arrays.copyOf(state, state.length + 1);
                            stateArr[stateArr.length - 1] = "正常";
                            state = stateArr;
                            System.out.println("用户添加成功！");
                        } else {
                            System.out.println("用户已存在，不能重复添加！！！");
                        }

                        System.out.print("输入0返回上级菜单：");
                        n = scanner.nextInt();
                        break;
                    case 3:
                        System.out.println("执行删除用户信息");

                        System.out.print("请输入删除用户的姓名：");
                        String delName = scanner.next();
                        int dindex = userIndex(name, delName);
                        // 用户存在才可删除
                        if (dindex != -1) {
                            String[] nameArr = Arrays.copyOf(name, name.length - 1);
                            int[] ageArr = Arrays.copyOf(age, age.length - 1);
                            String[] stateArr = Arrays.copyOf(state, state.length - 1);
                            for (int i = 0; i < name.length; i++) {
                                if (i != dindex) {
                                    int j = i !=0 ? i-1 : i;
                                    nameArr[j] = name[i];
                                    ageArr[j] = age[i];
                                    stateArr[j] = state[i];
                                }
                            }
                            name = nameArr;
                            age = ageArr;
                            state = stateArr;
                            System.out.println("用户删除成功！");
                        } else {
                            System.out.println(delName + "用户不存在，删除失败！！！");
                        }

                        System.out.print("输入0返回上级菜单：");
                        n = scanner.nextInt();
                        break;
                    case 4:
                        System.out.println("执行账户冻结");

                        System.out.print("请输入冻结用户的姓名：");
                        String freezeName = scanner.next();
                        int findex = userIndex(name, freezeName);
                        // 用户是否存在
                        if (findex != -1) {
                            if (name[findex].equals("冻结")) {
                                System.out.println("该用户已被冻结，不能再次操作！！！");
                            } else {
                                state[findex] = "冻结";
                            }
                            System.out.println("用冻结成功！");
                        } else {
                            System.out.println(freezeName + "用户不存在，冻结失败！！！");
                        }

                        System.out.print("输入0返回上级菜单：");
                        n = scanner.nextInt();
                        break;
                    case 5:
                        System.out.println("执行账户解冻");

                        System.out.print("请输入解冻用户的姓名：");
                        String unsealName = scanner.next();
                        int uindex = userIndex(name, unsealName);
                        // 用户是否存在
                        if (uindex != -1) {
                            if (name[uindex].equals("正常")) {
                                System.out.println("该用户已解冻，不能再次操作！！！");
                            } else {
                                state[uindex] = "正常";
                            }
                            System.out.println("用户解冻成功！");
                        } else {
                            System.out.println(unsealName + "用户不存在，解冻失败！！！");
                        }

                        System.out.print("输入0返回上级菜单：");
                        n = scanner.nextInt();
                        break;
                    case 6:
                        n = 6;
                        System.out.println("执行退出系统");
                        break;
                    default:
                        System.out.println("输入有误，请重新输入！！！");
                        System.out.print("请选择：");
                        break;
                }
            }
        } while (n != 6);
        System.out.println();
        System.out.println("已退出系统，感谢使用！");
    }

    // 用户信息列表
    public static void userList(String[] name, int[] age, String[] state) {
        for (int i = 0; i < name.length; i++) {
            System.out.print(i+1 + "\t\t\t");
            System.out.print(name[i] + "\t\t");
            System.out.print(age[i] + "\t\t\t");
            System.out.println(state[i]);
        }
    }

    // 获取用户对应的索引值
    public static int userIndex(String[] nameArr, String name) {
        for (int i = 0; i < nameArr.length; i++) {
            if (nameArr[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
