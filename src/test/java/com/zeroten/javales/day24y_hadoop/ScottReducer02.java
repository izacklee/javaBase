package com.zeroten.javales.day24y_hadoop;

import com.zeroten.javales.day24y_hadoop.zookeeper.ZK;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScottReducer02 extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

    @Override
    protected void reduce(IntWritable empno, Iterable<DoubleWritable> sals, Context context) throws IOException, InterruptedException {
//        super.reduce(empno, values, context);

        // 获取scott的工资
        double scottsal = Double.valueOf(ZK.map.get("SCOTT").toString());

        for(DoubleWritable sal : sals) {

            // 判断比scott工资高的
            if (sal.get() > scottsal) {

                context.write(empno, new DoubleWritable(sal.get()));
            }
        }
    }
}
