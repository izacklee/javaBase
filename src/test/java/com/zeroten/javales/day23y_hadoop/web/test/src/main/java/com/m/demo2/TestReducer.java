package com.m.demo2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * shuffle(yarn)阶段除了会排序外，还会分组
 * a:{1} -> a 1
 * b:{1} -> b 1
 * c:{1} -> c 1
 * d:{1} -> d 1
 * hello:{1,1,1,1} -> hello 4
 */
public class TestReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    // 每一次reduce调用，都会读取合并后的某个数据
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
//        super.reduce(key, values, context);

        int sum = 0; // 单词出现的次数
        for (IntWritable i : values) {
            sum += i.get(); // 累计数量
        }
        context.write(key, new IntWritable(sum));
    }
}
