package com.zeroten.javales.day24y_hadoop;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScottCombiner extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

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
        context.write(new IntWritable(1), new DoubleWritable(avg));
    }
}