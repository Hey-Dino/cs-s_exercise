package com.dino.pojo;

public class User {
    private int id;
    private String uname;
    private Double money;

    public User() {
    }

    public User(int id, String uname, Double money) {
        this.id = id;
        this.uname = uname;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", money=" + money +
                '}';
    }
}
