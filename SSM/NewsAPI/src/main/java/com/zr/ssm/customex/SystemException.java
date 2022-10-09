package com.zr.ssm.customex;

import com.zr.ssm.pojo.ExType;
import lombok.Data;

/**
 * @author 中软zhang
 * @create 2022-09-27 9:47
 */
@Data
public class SystemException extends RuntimeException{
    private ExType type;

    public SystemException(String message, ExType type) {
        super(message);
        this.type = type;
    }

    public SystemException(String message, ExType type, Throwable t) {
        super(message, t);
        this.type = type;
    }
}
