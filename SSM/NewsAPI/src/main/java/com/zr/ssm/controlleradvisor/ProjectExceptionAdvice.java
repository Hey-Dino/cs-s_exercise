package com.zr.ssm.controlleradvisor;


import com.zr.ssm.customex.BussinessException;
import com.zr.ssm.customex.SystemException;
import com.zr.ssm.pojo.Code;
import com.zr.ssm.pojo.ExType;
import com.zr.ssm.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 中软zhang
 * @create 2022-09-27 8:57
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //捕获自定义的业务层异常
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

    //捕获自定义的系统异常，可以通过try。。catch捕获然后抛出我们自定义的异常
    @ExceptionHandler({SystemException.class})
    public Result dealSystemException(SystemException t) {
        System.out.println(t.getMessage());
        System.out.println(t.getCause());
        System.out.println("系统异常被捕获了");
        t.getCause().printStackTrace();
        if (t.getType() == ExType.SystemDbTimeOut) {
            Result result = new Result(0, "query one artical fail" + t.getMessage());
            return result;
        }
        // 通知运维人员， 发短信
        // 写日志
        Result result = new Result(500, "系统繁忙  ！", null, Code.Exception);
        return result;
    }

    //捕获其他异常
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
