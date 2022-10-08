package com.chinasoft.news.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 响应结果的构造函数
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    Integer status;
    String message;
    Object data;
    String token;
    Code code;

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(Integer status, String message, Object data,  Code code) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.code = code;
    }
}
