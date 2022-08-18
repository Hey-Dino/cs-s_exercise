package com.dino.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer eid;
    private String empName;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer eid, String empName, Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.dept = dept;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

}
