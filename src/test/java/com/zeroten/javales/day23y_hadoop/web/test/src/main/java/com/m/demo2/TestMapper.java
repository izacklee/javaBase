package com.m.demo2;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 词频统计：mr的helloword
 * hello a
 * hello b
 * hello c
 * hello d
 *
 * Mapper<KEYIN, VALUEIN, KEYPUT, VALUEOUT>
 *     KEYIN：偏移量（从哪开始读，也就是下标，下标从0开始，换行后依旧递增而不是再从0开始）
 *     VALUEIN：读取的数据类型
 */

public class TestMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    // 和线程当中的run方法类似，不需要你自己调用，有mr调用
    @Override
    protected void map(LongWritable key, Text value,
                       Mapper<LongWritable, Text, Text, IntWritable>.Context context)
                       throws IOException, InterruptedException {
//        super.map(key, value, context);

        // 每调用一次读取一行
        String line = value.toString(); // 读取到的某一行，但不确定是哪一行
        String[] values = line.split(" "); // ["hello", "a"]
        for (String v : values) {
                        // 包装类往外写   // 出现几次
            context.write(new Text(v), new IntWritable(1));
        }
        /**
         * Map阶段——输出结果例子（顺序可能不一样）：
         * hello 1
         * a 1
         * hello 1
         * b 1
         * hello 1
         * c 1
         * hello 1
         * d 1
         */

    }

}
