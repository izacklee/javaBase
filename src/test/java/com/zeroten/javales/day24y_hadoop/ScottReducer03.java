package com.zeroten.javales.day24y_hadoop;

import com.zeroten.javales.day24y_hadoop.entity.EmpWritable;
import com.zeroten.javales.day24y_hadoop.zookeeper.ZK;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScottReducer03 extends Reducer<IntWritable, EmpWritable, IntWritable, EmpWritable> {

    @Override
    protected void reduce(IntWritable empno, Iterable<EmpWritable> emps, Context context) throws IOException, InterruptedException {
//        super.reduce(empno, values, context);

        // 获取scott的工资
        double scottsal = Double.valueOf(ZK.map.get("SCOTT").toString());

        for(EmpWritable emp : emps) {

            // 判断比scott工资高的
            if (emp.getSal() > scottsal) {

                context.write(empno, emp);
            }
        }
    }
}
