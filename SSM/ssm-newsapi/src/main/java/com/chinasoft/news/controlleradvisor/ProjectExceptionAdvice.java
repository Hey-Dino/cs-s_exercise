package com.chinasoft.news.controlleradvisor;

import com.chinasoft.news.customexception.BussinessException;
import com.chinasoft.news.customexception.SystemException;
import com.chinasoft.news.pojo.Code;
import com.chinasoft.news.pojo.ExType;
import com.chinasoft.news.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler({BussinessException.class})
    public Result dealBussinessException(BussinessException t) {
        // 处理业务异常
        System.out.println(t.getMessage());
        System.out.println(t);
        System.out.println("异常被捕获了");
        // 无效token的异常处理
        if (t.getType() == ExType.BussInvalidToken) {
            Result result = new Result(4, "ex Handler: " + t.getMessage(), null, Code.Exception);
            return result;
        }
        Result result = new Result(300, t.getMessage(), null, Code.Exception);
        return result;
    }

    @ExceptionHandler({SystemException.class})
    public Result dealSystemException(SystemException t) {
        System.out.println(t.getMessage());
        System.out.println(t.getCause());
        System.out.println("系统异常被捕获了");
        t.getCause().printStackTrace();
        // 通知运维人员， 发短信
        // 写日志
        Result result = new Result(500, "系统繁忙  ！", null, Code.Exception);
        return result;
    }

    @ExceptionHandler({Exception.class})
//    @ExceptionHandler({ArithmeticException.class, SQLException.class})
    public Result dealException(Throwable t) {
        System.out.println(t.getMessage());
        System.out.println(t);
        System.out.println("异常被捕获了");
        // 处理
        Result result = new Result(500, "异常发生了 " + t.getMessage(), null, Code.Exception);
        return result;
    }
}
