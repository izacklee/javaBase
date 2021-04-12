package com.zeroten.javales.day24y_hadoop;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScottReducer04 extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

    @Override
    protected void reduce(IntWritable deptno, Iterable<DoubleWritable> sals, Context context) throws IOException, InterruptedException {
//        super.reduce(deptno, sals, context);

        double maxavg = 0;
        for (DoubleWritable sal : sals) {
            if (maxavg == 0) {
                maxavg = sal.get();
            } else {
                // 依次找到工资最大的那个
                if (maxavg < sal.get()) {
                    maxavg = sal.get();
                }
            }
        }

        // 往外写
        context.write(new IntWritable(1), new DoubleWritable(maxavg));
    }
}