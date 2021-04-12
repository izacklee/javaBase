package com.zeroten.javales.day28y_jdbc.vo;

public class EmpAndDeptVo {
    private Integer empno;
    private String ename;
    private Integer deptno;
    private String dname;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "EmpAndDeptVo{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", deptno=" + deptno +
                ", dname='" + dname + '\'' +
                '}';
    }
}
