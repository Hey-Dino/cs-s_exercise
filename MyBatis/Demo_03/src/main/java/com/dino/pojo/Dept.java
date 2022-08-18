package com.dino.pojo;

import java.util.List;

public class Dept {
    private Integer did;
    private String deptName;
    private String loc;
    private List<Emp> emps;

    public Dept() {
    }

    public Dept(Integer did, String deptName, String loc) {
        this.did = did;
        this.deptName = deptName;
        this.loc = loc;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", loc='" + loc + '\'' +
                ", emps=" + emps +
                '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

}
