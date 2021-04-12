package com.zeroten.javales.day24y_hadoop;

import com.zeroten.javales.day24y_hadoop.zookeeper.ZK;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

/**
 * 求工资比SCOTT要高的人（子查询）
 */
public class ScottMapper02 extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);

        // 把每行数据拆分成组
        String line = value.toString();
        String[] values = line.split(",");

        // 获取数据信息并转换数据类型
        int empno = Integer.valueOf(values[0]); // 员工号
        String ename = values[1]; // 姓名
        double sal = Double.valueOf(values[5]); // 工资

        // 把不是SCOTT的人平摊出去（尽可能的做到平摊 所以这里不建议用deptno 会造成数据倾斜 用empno）
        if (!"SCOTT".equals(ename)) {
            context.write(new IntWritable(empno), new DoubleWritable(sal));
        } else {
            ZK.map.put("SCOTT", sal);
        }

    }
}
