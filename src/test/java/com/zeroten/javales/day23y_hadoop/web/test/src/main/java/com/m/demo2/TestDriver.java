package com.m.demo2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 1 windows强制加载hadoop.dll mac不需要
//        System.loadLibrary("/usr/local/hadoop/bin/hadoop"); // 不包含扩展名
//        System.load("/usr/local/hadoop/bin/hadoop"); // 一般用这个

        // 2 指定用户，指定hadoop的根目录
        System.setProperty("HADOOP_USER_NAME", "root");
        System.setProperty("hadoop.home.dir", "/usr/local/hadoop");

        // 3 创建与hdfs的连接
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://www.hadoopceshi.com:9000");

        // 4 创建查询任务
        Job job = Job.getInstance(conf, "wc1");
        // 5 指定主执行类
        job.setJarByClass(TestDriver.class);
        // 6 指定map执行类
        job.setMapperClass(TestMapper.class);
        // 7 指定reduce执行类
        job.setReducerClass(TestReducer.class);
        // 8 指定map阶段输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        // 9 指定reduce输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 10 输入文本的地址 可单个文件或多个文件 多个逗号隔开
        FileInputFormat.setInputPaths(
                job, new Path("/input/wordcount"));
        // 11 输出文件目录地址
        FileOutputFormat.setOutputPath(job, new Path("/output/out01")); // 输出路径必须是不存在的，否则报错
        // 12 执行
        // true表示将运行进度等信息及时输出给用户，false的话只是等待作业结束
        System.out.println(job.waitForCompletion(true));

    }
}
