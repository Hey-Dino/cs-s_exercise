package cn.dino.demo.Demo0806.Demo01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(mc);
        // 创建线程对象
        Thread t1 = new Thread(ft);
        // 设置线程优先级
        t1.setPriority(10);
        // 开启线程
        t1.start();

        // 获取 call() 方法的返回值
        System.out.println(ft.get());

        MyCallable mc2 = new MyCallable();
        FutureTask<String> ft2 = new FutureTask<>(mc2);
        // 创建线程对象
        Thread t2 = new Thread(ft2);
        // 设置线程优先级
        t2.setPriority(1);
        // 开启线程
        t2.start();
    }
}
