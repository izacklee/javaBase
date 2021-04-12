package com.zeroten.javales.day24y_hadoop;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * mapper阶段
 * 20 800
 * 30 1600
 * ......
 * 15个数据输出
 *
 * shuffle(yarn)阶段除了会排序外，还会分组
 * 10:{2450,5000...}
 * 20:{800,2975...}
 * 30:{}
 * 102:{}
 *
 * 4次Reduce执行（shuffle排序分组后才会执行Reduce，所以是4次）
 *
 */
public class ScottReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

    @Override
    protected void reduce(IntWritable deptno, Iterable<DoubleWritable> sals, Context context) throws IOException, InterruptedException {
//        super.reduce(deptno, sals, context);

        double avg = 0;
        int count = 0;

        for (DoubleWritable sal : sals) {
            avg += sal.get(); // 每次获取工资，累加
            count++;
        }
        avg /= count; // 求平均工资

        // 往外写
        context.write(deptno, new DoubleWritable(avg));
    }
}
