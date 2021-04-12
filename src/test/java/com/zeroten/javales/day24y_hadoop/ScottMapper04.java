package com.zeroten.javales.day24y_hadoop;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 求平均工资最高的部门
 */

public class ScottMapper04 extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {

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
