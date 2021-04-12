package com.zeroten.javales.day24y_hadoop;


import com.zeroten.javales.day24y_hadoop.entity.EmpWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 驱动类
 */
public class ScottDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 1 windows强制加载hadoop.dll mac不需要
//        System.load("/usr/local/hadoop/bin/hadoop");

        // 2 指定用户，指定hadoop根目录
        System.setProperty("HADOOP_USER_NAME", "root");
        System.setProperty("hadoop.home.dir", "/usr/local/hadoop");

        // 3.创建与hdfs的连接
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://www.hadoopceshi.com:9000");

        // 4 创建查询任务
//        Job job = Job.getInstance(conf, "scott1"); // 求平均工资
//        Job job = Job.getInstance(conf, "scott2");  // 求工资比SCOTT要高的人（子查询）
//        Job job = Job.getInstance(conf, "scott3");  // 求工资比SCOTT要高的人（子查询）,结果是所有信息
        Job job = Job.getInstance(conf, "scott4");  // 求平均工资最高的部门

        // 5 指定执行主体类
        job.setJarByClass(ScottDriver.class);

        // 6 指定map执行类
//        job.setMapperClass(ScottMapper.class);
//        job.setMapperClass(ScottMapper02.class); // 求工资比SCOTT要高的人（子查询）
//        job.setMapperClass(ScottMapper03.class); // 求工资比SCOTT要高的人（子查询）,结果是所有信息
        job.setMapperClass(ScottMapper04.class); // 求平均工资最高的部门

        // 7.指定reducer执行类
        job.setCombinerClass(ScottCombiner.class); // 这也是reduce，只不过他是在最终reduce之前完成的一步

//        job.setReducerClass(ScottReducer.class);
//        job.setReducerClass(ScottReducer02.class); // 求工资比SCOTT要高的人（子查询）
//        job.setReducerClass(ScottReducer03.class); // 求工资比SCOTT要高的人（子查询）,结果是所有信息
        job.setReducerClass(ScottReducer04.class); // 求平均工资最高的部门

        // 8.指定map阶段输出类型
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(DoubleWritable.class);
//        job.setMapOutputValueClass(EmpWritable.class); // 求工资比SCOTT要高的人（子查询）,结果是所有信息

        // 9.指定reduce输出类型
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(DoubleWritable.class);
//        job.setOutputValueClass(EmpWritable.class); // 求工资比SCOTT要高的人（子查询）,结果是所有信息

        // 10.输入文本的地址 可单个文件或多个文件 多个逗号隔开
        FileInputFormat.setInputPaths(
                job, new Path("/input/emp.csv")
        );
//        FileInputFormat.setInputPaths(
//                job, new Path("/output/salmaxavg/part-r-00000")  // 可以添加多个MR连续执行，一个执行完再执行下一个
//        );

        // 11.输出文件目录地址
        // 输出路径必须是不存在的，否则报错
//        FileOutputFormat.setOutputPath(
//                job, new Path("/output/salavg")
//        );
//        FileOutputFormat.setOutputPath(
//                job, new Path("/output/gtscottsal")  // 求工资比SCOTT要高的人（子查询）
//        );
//        FileOutputFormat.setOutputPath(
//                job, new Path("/output/gtscottsal2")  // 求工资比SCOTT要高的人（子查询）,结果是所有信息
//        );
        FileOutputFormat.setOutputPath(
                job, new Path("/output/salmaxavg")  // 求平均工资最高的部门
        );

        // 12.执行
        // true表示将运行进度等信息及时输出给用户，false的话只是等待作业结束
        System.out.println(job.waitForCompletion(true));
    }
}
