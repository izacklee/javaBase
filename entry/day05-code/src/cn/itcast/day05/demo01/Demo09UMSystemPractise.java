package cn.itcast.day05.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
 练习：用户管理系统

 优化版
*/
public class Demo09UMSystemPractise {

    // 初始化数据
    // 姓名数组
    static String[] names = {"张三", "李四", "王五"};
    // 年龄数组
    static int[] ages = {20, 22, 25};
    // 状态数组
    static String[] states = {"正常", "正常", "正常"};

    public static void main(String[] args) {
        // 系统流程控制
        Scanner scanner = new Scanner(System.in);
        int num;
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

            num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("执行查询用户信息");
                    // 用户列表
                    userList();

                    // 输入0返回上级菜单
                    num = returnMenus(scanner);
                    break;
                case 2:
                    System.out.println("执行添加用户信息");
                    // 添加用户
                    addUser(scanner);

                    // 输入0返回上级菜单
                    num = returnMenus(scanner);
                    break;
                case 3:
                    System.out.println("执行删除用户信息");
                    // 删除用户
                    delUser(scanner);

                    // 输入0返回上级菜单
                    num = returnMenus(scanner);
                    break;
                case 4:
                    System.out.println("执行账户冻结");
                    // 冻结用户
                    freezeUser(scanner);

                    // 输入0返回上级菜单
                    num = returnMenus(scanner);
                    break;
                case 5:
                    System.out.println("执行账户解冻");
                    // 解冻用户
                    unsealUser(scanner);

                    // 输入0返回上级菜单
                    num = returnMenus(scanner);
                    break;
                case 6:
                    num = 6;
                    System.out.println("执行退出系统");
                    break;
                default:
                    num = 0;
                    System.out.println("输入有误，请重新输入！！！");
                    break;
            }
        } while (num == 0);
        System.out.println();
        System.out.println("已退出系统，感谢使用！");
    }

    // 用户信息列表
    public static void userList() {
        System.out.println("----------用户信息列表----------");
        System.out.println("编号\t\t姓名\t\t年龄\t\t状态");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i+1 + "\t\t\t" + names[i] + "\t\t" + ages[i] + "\t\t\t" + states[i]);
        }
    }

    // 添加用户
    public static void addUser(Scanner scanner) {
        System.out.print("请输入添加用户的姓名：");
        String newName = scanner.next();
        System.out.print("请输入添加用户的年龄：");
        int newAge = scanner.nextInt();
        int index = userIndex(newName);
        // 用户不存在才添加
        if (index == -1) {
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = newName;
            ages = Arrays.copyOf(ages, ages.length + 1);
            ages[ages.length - 1] = newAge;
            states = Arrays.copyOf(states, states.length + 1);
            states[states.length - 1] = "正常";
            System.out.println("用户添加成功！");
        } else {
            System.out.println("用户已存在，不能重复添加！！！");
        }
    }

    // 删除用户
    public static void delUser(Scanner scanner) {
        System.out.print("请输入删除用户的姓名：");
        String delName = scanner.next();
        int dindex = userIndex(delName);
        // 用户存在才可删除
        if (dindex != -1) {
            String[] name = names;
            int[] age = ages;
            String[] state = states;
            names = Arrays.copyOf(names, names.length - 1);
            ages = Arrays.copyOf(ages, ages.length - 1);
            states = Arrays.copyOf(states, states.length - 1);
            for (int i = dindex; i < names.length; i++) {
                // 将数组从删除位置起，之后的所有元素整体向前移动一位
                names[i] = name[i+1];
                ages[i] = age[i+1];
                states[i] = state[i+1];
            }
            System.out.println("用户删除成功！");
        } else {
            System.out.println(delName + "用户不存在，删除失败！！！");
        }
    }

    // 冻结用户
    public static void freezeUser(Scanner scanner) {
        System.out.print("请输入冻结用户的姓名：");
        String freezeName = scanner.next();
        int findex = userIndex(freezeName);
        // 用户是否存在
        if (findex != -1) {
            if (states[findex].equals("冻结")) {
                System.out.println("该用户已被冻结，不能再次操作！！！");
            } else {
                states[findex] = "冻结";
                System.out.println("用冻结成功！");
            }
        } else {
            System.out.println(freezeName + "用户不存在，冻结失败！！！");
        }
    }

    // 解冻用户
    public static void unsealUser(Scanner scanner) {
        System.out.print("请输入解冻用户的姓名：");
        String unsealName = scanner.next();
        int uindex = userIndex(unsealName);
        // 用户是否存在
        if (uindex != -1) {
            if (states[uindex].equals("正常")) {
                System.out.println("该用户已解冻，不能再次操作！！！");
            } else {
                states[uindex] = "正常";
                System.out.println("用户解冻成功！");
            }
        } else {
            System.out.println(unsealName + "用户不存在，解冻失败！！！");
        }
    }

    // 获取用户对应的索引值
    public static int userIndex(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // 输入0返回上级菜单
    public static int returnMenus(Scanner scanner) {
        int num;
        while (true) {
            System.out.print("输入0返回上级菜单：");
            num = scanner.nextInt();
            if (num == 0) {
                return num;
            }
            System.out.println("输入有误，请重新输入！！！");
        }
    }
}
