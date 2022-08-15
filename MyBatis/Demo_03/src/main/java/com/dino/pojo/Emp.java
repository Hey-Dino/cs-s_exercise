package com.dino.pojo;

public class Emp {
    private Integer id;
    private String empName;
    private Integer did;

    public Emp() {
    }

    public Emp(Integer id, String empName, Integer did) {
        this.id = id;
        this.empName = empName;
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", did=" + did +
                '}';
    }
}
