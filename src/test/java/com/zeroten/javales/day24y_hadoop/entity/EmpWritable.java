package com.zeroten.javales.day24y_hadoop.entity;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

/**
 * Serializable的目的，主机与主机之间数据通信必须是可序列化的
 *
 * 因为主机与主机之间（两台服务器之间）通信主要就是传字符串、对象，用流来进行，流有字节流，字符流，
 * 二进制流，对象的序列化和反序列化等
 * 又因本例子传递的是对象，所以就需要通过二进制流，或序列化和反序列化，但无论是哪种都需要保证数据是可序列化的才行
 */

public class EmpWritable implements Writable, Serializable {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hdate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    public EmpWritable() {

    }

    public EmpWritable(String line) {
        String[] values = line.split(",");
        this.setEmpno(values[0]);
        this.setEname(values[1]);
        this.setJob(values[2]);
        this.setMgr(values[3]);
        this.setHdate(values[4]);
        this.setSal(values[5]);
        this.setComm(values[6]);
        this.setDeptno(values[7]);
    }

    public EmpWritable(Integer empno, String ename, String job, Integer mgr, String hdate, Double sal,
                       Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hdate = hdate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = Integer.valueOf(empno);
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public void setMgr(String mgr) {

        try{
            this.mgr = Integer.valueOf(mgr); // 为空时抛异常
        } catch(Exception e) {
            this.mgr = 0 ;
        }
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public void setSal(String sal) {
        this.sal = Double.valueOf(sal);
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public void setComm(String comm) {

        try{
            this.comm = Double.valueOf(comm); // 为空时抛异常
        } catch(Exception e) {
            this.comm = 0d ;
        }
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = Integer.valueOf(deptno);
    }

    @Override
    public String toString() {
        return "EmpWritable{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hdate='" + hdate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }

    // 序列化后，写数据
    @Override
    public void write(DataOutput out) throws IOException {

        out.writeInt(this.empno);
        out.writeUTF(this.ename);
        out.writeUTF(this.job);
        out.writeInt(this.mgr);
        out.writeUTF(this.hdate);
        out.writeDouble(this.sal);
        out.writeDouble(this.comm);
        out.writeInt(this.deptno);
    }

    // 序列化后，读取数据
    @Override
    public void readFields(DataInput in) throws IOException {
        this.empno = in.readInt();
        this.ename = in.readUTF();
        this.job = in.readUTF();
        this.mgr = in.readInt();
        this.hdate = in.readUTF();
        this.sal = in.readDouble();
        this.comm = in.readDouble();
        this.deptno = in.readInt();

    }
}
