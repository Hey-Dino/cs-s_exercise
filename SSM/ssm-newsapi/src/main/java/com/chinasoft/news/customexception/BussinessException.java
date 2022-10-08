package com.chinasoft.news.customexception;

import com.chinasoft.news.pojo.ExType;
import lombok.Data;

/**
 * @author 中软zhang
 * @create 2022-09-27 9:47
 */
@Data
public class BussinessException extends RuntimeException{
    private ExType type;

    public BussinessException(String message, ExType type) {
        super(message);
        this.type = type;
    }

    public BussinessException(String message, ExType type, Throwable t) {
        super(message, t);
        this.type = type;
    }
}
