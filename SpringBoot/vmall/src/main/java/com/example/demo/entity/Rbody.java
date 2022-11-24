package com.example.demo.entity;

public class Rbody<T> {

    private T data;
    private State meta;

    public Rbody() {
    }

    public Rbody(T data, State meta) {
        this.data = data;
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public State getMeta() {
        return meta;
    }

    public void setMeta(State meta) {
        this.meta = meta;
    }
}
