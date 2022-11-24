package com.example.demo.entity;

import lombok.Data;

@Data
public class State {

    private String msg;
    private int status;

    public State(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    /*public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }*/
}