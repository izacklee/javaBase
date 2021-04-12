package com.zeroten.javales.day27y_jdbc.entity;

import com.zeroten.javales.day27y_jdbc.annt.*;

@UseSql(sql="SELECT * ")
@AutoCommit(true)
@Table(value = "dept")
public class Dept {
    @Column("deptno")
    private Integer deptno;
    @Column("dname")
    private String dname;
    @Column(value="loc", condition="!=", select=false)
    private String loc;

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public Dept setDeptno(Integer deptno) {
        this.deptno = deptno;
        return this;
    }

    public String getDname() {
        return dname;
    }

    public Dept setDname(String dname) {
        this.dname = dname;
        return this;
    }

    public String getLoc() {
        return loc;
    }

    public Dept setLoc(String loc) {
        this.loc = loc;
        return this;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
