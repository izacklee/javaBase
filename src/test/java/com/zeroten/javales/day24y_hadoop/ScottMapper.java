package com.zeroten.javales.day24y_hadoop;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 求平均工资
 *
 * 7369,SMITH,CLERK,7902,1980-12-17,800,,20
 * 7499,ALLEN,SALESMAN,7698,1981-02-20,1600,300,30
 * 7521,WARD,SALESMAN,7698,1981-02-22,1250,500,30
 * 7566,JONES,MANAGER,7839,1981-04-02,2975,,20
 * 7654,MARTIN,SALESMAN,7698,1981-09-28,1250,1400,30
 * 7698,BLAKE,MANAGER,7839,1981-05-01,2850,,30
 * 7782,CLARK,MANAGER,7839,1981-06-09,2450,,10
 * 7788,SCOTT,ANALYST,7566,1987-07-13,3000,,20
 * 7839,KING,PRESIDENT,,1981-11-17,5000,,10
 * 7844,TURNER,SALESMAN,7698,1981-09-08,1500,0,30
 * 7876,ADAMS,CLERK,7788,1987-07-13,1100,,20
 * 7900,JAMES,CLERK,7698,1981-12-03,950,,30
 * 7902,FORD,ANALYST,7566,1981-12-03,3000,,20
 * 7934,MILLER,CLERK,7782,1982-01-23,1300,,10
 * 7935,SMITH2,CLERK2,79022,1980-12-17,802,,102
 */

public class ScottMapper extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);

        // 把每行数据拆分成数组
        String line = value.toString();
        String[] values = line.split(",");

        // 获取薪资和部门号
        String salStr = values[5];
        String deptStr = values[7];

        // 转换类型
        int dept = Integer.valueOf(deptStr);
        double sal = Double.valueOf(salStr);

        // 往外写
        context.write(new IntWritable(dept), new DoubleWritable(sal));
    }
}
/**
 * map阶段输出结果应该为（实际顺序可能不一样，乱序）：
 * 20 800
 * 30 1600
 * 30 1250
 * ......
 * 15个数据输出
 */
