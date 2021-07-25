package cn.itcast.day05.demo01;

/*
使用静态初始化数组的时候，格式还可以省略一下。

标准格式：
    数组类型[] 数组名称 = new 数据类型[] { 元素1, 元素2, ... };

省略格式：
    数据类型[] 数组名称 = { 元素1, 元素2, ... };

注意事项：
    1.静态初始化没有直接指定长度，但是仍然会自动推算得到长度。
    2.静态初始化标准格式可以拆分成两个步骤。
    3.动态初始化也可以拆分成两个步骤。
    4.静态初始化一旦使用省略格式，就不能拆分成两个步骤了。
*/

import java.util.Arrays;

public class Demo03Array {
    public static void main(String[] args) {
        // 省略格式静态初始化
        int[] arrayA = { 10, 20, 30 };

        // 静态初始化的标准格式，可以拆分成两个步骤
        int[] arrayB;
        arrayB = new int[] { 12, 13, 14 };

        // 动态初始化也可以拆分成两个步骤
        int[] arrayC;
        arrayC = new int[2];




        // 将25插入下标为3的位置
        int[] arr = {20, 10, 8, 6, 100, 1};
        // 创建新数组
        int[] arr2 = new int[arr.length+1];
        int num = 25; // 插入的数据
        int index = 3; // 将数据插入下标的位置
       /* for (int i = 0; i < arr2.length; i++) {
            if (i == index) {
                arr2[i] = num;
            } else {
                int val = 0;
                if (i < index) val = arr[i]; // 插入位置之前的数据直接复制到新数组对应的位置
                if (i > index) val = arr[i-1]; // 插入位置之后的数据依次向后移动一位
                arr2[i] = val;
            }
        }*/

       // 插入下标之前的数据直接复制到对应的位置
        for (int i = 0; i < index; i++) {
            arr2[i] = arr[i];
        }

        // 插入位置之后的数据依次向后移动一位
        for (int i = index + 1; i < arr2.length; i++) {
            arr2[i] = arr[i - 1];
        }

        // 将目标数据插入指定的下标位置
        arr2[index] = num;

        System.out.println("添加前的数组：" + Arrays.toString(arr));
        System.out.println("添加后的数组：" + Arrays.toString(arr2));

        // 将下列数组升序排序
        int[] arr4 = {13, 6, 8, 2, 10, 50, 7};
//        int[] arr4 = {50, 13, 10, 8, 7, 6, 2};
        int len = arr4.length;
        int n = 0;
//        bubbleSort(arr4); // 冒泡排序
//        selectSort(arr4); // 选择排序
//        insertSort(arr4); // 插入排序
        quickSort(arr4); // 快速排序

        // 普通排序法 循环42次
        /*for (int i = 0; i < len; i++) {
            for (int j = 0; j < len -1; j++) {
                n++;
                if (arr4[j] > arr4[j+1]) {
                    int temp = arr4[j];
                    arr4[j] = arr4[j+1];
                    arr4[j+1] = temp;
                }
            }
        }*/
        // 冒泡排序法（从右侧开始排） 循环21次
        /*for (int i = 1; i < len; i++) {
            // 循环每一轮冒泡数，找出最大值
            for (int j = 0; j < len-i; j++) {
                n++;
                // 当前值大于下一个值，则互换位置
                if (arr4[j] > arr4[j+1]) {
                    int temp = arr4[j];
                    arr4[j] = arr4[j+1];
                    arr4[j+1] = temp;
                }
            }
        }*/

        // 选择排序法（从左侧开始排） 循环21次
        /*for (int i = 0; i < len - 1; i++) {
            int q = i; // 假设最小值的位置
            *//* int q = i; // 记录最小值的位置
           int m = i; // 记录假设最小值的位置
            int min = arr4[i]; // 假设最小值*//*
            // 循环每一轮选择的数据
            for (int j = i + 1; j < len; j++) {
                n++;
                // 判断当前值是否比假设值还小
                *//*if (arr4[j] < min) {
                    min = arr4[j]; // 替换假设的最小值
                    q = j; // 替换记录最小值的位置
                }*//*
                if (arr4[j] < arr4[q]) {
                    q = j; // 替换最小值的位置
                }
            }

            // 假设最小值的位置与真实最小值的位置不等，则互换值
            *//*if (m != q) {
                int temp = arr4[m];
                arr4[m] = arr4[q];
                arr4[q] = temp;
            }*//*

            if (i != q) {
                int temp = arr4[i];
                arr4[i] = arr4[q];
                arr4[q] = temp;
            }
        }*/

        // 插入排序法（从左侧开始，当前值比上一个值小，那么将当前值与上一个值互换） 循环21次
        /*for (int i = 1; i < len; i++) {
            int m = arr4[i];
            for (int j = i - 1; j >= 0; j--) {
                n++;
                if (arr4[j] > m) {
                    int temp = arr4[j];
                    arr4[j] = arr4[j+1];
                    arr4[j+1]=temp;
                }
            }
        }
*/
      /*  // 快速排序法
        quickSort(arr4);*/

        System.out.println(n);
        System.out.println("数组升序排序后的结果：" + Arrays.toString(arr4));
    }

   /* // 快速排序
    public static void quickSort(int[] arr) {
        // 左侧初始值
        int low = 0;
        // 右侧最大值
        int high = arr.length - 1;
        // 调用分区查询方法
        partition(arr,low,high);
    }

    // 分区查询方法
    public static void partition(int[] arr, int low, int high) {
        // 查询结束判断
        if (low >= high) {
            return;
        }
        // 定义左指针l，右指针h
        int l = low;
        int h = high;

        // 定义一个初始值，作为中间值
        int mid = arr[low];

        while (l < h) {
            // 从右往左扫，找出比中间值还大的值
            while (arr[h] >= mid && l < h) {
                h--;
            }
            // 将比中间值还小的值，左移放到中间值的位置，并将左指针l++
            if (l < h) {
                arr[l] = arr[h];
                l++;
            }
            // 从左往右扫，找出比中间值还小的值
            while (arr[l] < mid && l < h) {
                l++;
            }
            // 将比中间值还大的值，右移放到前一步比中间值还小的值的位置，并将右指针h--
            if (l < h) {
                arr[h] = arr[l];
                h--;
            }
        }
        // 将中间值放到，最后预留的位置，也是中间值最终的位置
        arr[l] = mid;
        // 对左分区进行快速排序
        partition(arr,low,l-1);
        // 对右分区进行快速排序
        partition(arr,l+1,high);

    }*/


   // 冒泡排序 升序 右侧往左一次排好（右往左排） 相邻两数比较
    public static void bubbleSort(int[] arr) {
        /*// 拆分每一步排序法 length长度为7 所以需要循环7-1=6次
        // 第一次排序
        for (int i = 0; i < arr.length-1-0; i++) {
            // 如果前面的值大于后面的值，则互换位置
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第二次排序
        for (int i = 0; i < arr.length-1-1; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第三次排序
        for (int i = 0; i < arr.length-1-2; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第四次排序
        for (int i = 0; i < arr.length-1-3; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第五次排序
        for (int i = 0; i < arr.length-1-4; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第六次排序
        for (int i = 0; i < arr.length-1-5; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }*/

        // 优化排序 合并重复的循环
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    // 选择排序 升序 左侧依次往右排好（左往右排）每次选出最小值放到左边依次排序
    public static void selectSort(int[] arr) {
        /*// 拆分每一步排序法
        // 第一次排序
        int min = arr[0+0];
        int index = 0+0;
        for (int i = 1+0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        arr[index] = arr[0+0];
        arr[0+0] = min;

        // 第二次排序
        int min2 = arr[0+1];
        int index2 = 0+1;
        for (int i = 1+1; i < arr.length; i++) {
            if (arr[i] < min2) {
                min2 = arr[i];
                index2 = i;
            }
        }
        arr[index2] = arr[0+1];
        arr[0+1] = min2;

        // 第三次排序
        int min3 = arr[0+2];
        int index3 = 0+2;
        for (int i = 1+2; i < arr.length; i++) {
            if (arr[i] < min3) {
                min3 = arr[i];
                index3 = i;
            }
        }
        arr[index3] = arr[0+2];
        arr[0+2] = min3;

        // 第四次排序
        int min4 = arr[0+3];
        int index4 = 0+3;
        for (int i = 1+3; i < arr.length; i++) {
            if (arr[i] < min4) {
                min4 = arr[i];
                index4 = i;
            }
        }
        arr[index4] = arr[0+3];
        arr[0+3] = min4;

        // 第五次排序
        int min5 = arr[0+4];
        int index5 = 0+4;
        for (int i = 1+4; i < arr.length; i++) {
            if (arr[i] < min5) {
                min5 = arr[i];
                index5 = i;
            }
        }
        arr[index5] = arr[0+4];
        arr[0+4] = min5;

        // 第六次排序
        int min6 = arr[0+5];
        int index6 = 0+5;
        for (int i = 1+5; i < arr.length; i++) {
            if (arr[i] < min6) {
                min6 = arr[i];
                index6 = i;
            }
        }
        arr[index6] = arr[0+5];
        arr[0+5] = min6;*/

        // 优化排序 合并重复的循环 循环21次
        for (int j = 0; j < arr.length-1; j++) {
            int m = j; // 定义一个值，作为最小值
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[m]) {
                    m = i;
                }
            }
            // 如果j != m，则存在比当前值还小的值，需要互换
            if (j != m) {
                int temp = arr[j];
                arr[j] = arr[m];
                arr[m] = temp;
            }
        }

    }

    // 插入排序 升序 左侧最先排好（左往右排）取出下一个值，将该值与上一个值比较
    public static void insertSort(int[] arr) {
        /*// 拆分每一步排序法
        // 第一步排序
        for (int i = arr.length-1-6; i >= 0; i--) {
            // 取下一个值与上一个值比较，下一个值比它上一个值小，则互换
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第二步排序
        for (int i = arr.length-1-5; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

       // 第三步排序
        for (int i = arr.length-1-4; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

         // 第四步排序
        for (int i = arr.length-1-3; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第五步排序
        for (int i = arr.length-1-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // 第六步排序
        for (int i = arr.length-1-1; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }*/

        // 优化排序 合并重复的循环
        for (int j = 1; j < arr.length; j++) {
            for (int i = j - 1; i >=0; i--) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    // 快速排序 升序（按中间值，分左右区排序） 定义个中间值，以这个中间值作为分区界线，小于中间值放左边排序，大于中间值放右边排序
    public static void quickSort(int[] arr) {
        // 定义左指针的初始值
        int low = 0;
        // 定义右指针的初始值
        int high = arr.length-1;
        // 调用分区排序方法
        partition(arr, low, high);
    }

    // 分区排序方法
    public static void partition(int[] arr, int low, int high) {

        // 递归结束条件
        if (low >= high) {
            return;
        }

        // 定义左指针为l
        int l = low;
        // 定义右指针为h
        int h = high;
        // 取数组第一个值作为基准值
        int m = arr[low];

        // 遍历数组分区查找
        while (l < h) {
            // 右往左扫，比基准值大，h--
            while (arr[h] >= m && l < h) {
                h--;
            }
            // 将大于基准值的前一个值，放到基准值的位置，并l++
            if (l < h) {
              arr[l] = arr[h];
              l++;
            }

            // 左往右扫，比基准值小，l++
            while (arr[l] < m && l < h) {
                l++;
            }
            // 将小于基准值的下一个值，放到前一步大于基准值的值的位置，h--
            if (l < h) {
              arr[h] = arr[l];
              h--;
            }
        }

        // 将基准值放入小于基准值的值的位置，该位置为基准值最终的位置
        arr[l] = m;
        // 左分区排序查找
        partition(arr, low, l-1);
        // 右分区排序查找
        partition(arr, l+1, high);
    }

}
