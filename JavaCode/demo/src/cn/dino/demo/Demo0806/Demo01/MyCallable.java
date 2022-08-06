package cn.dino.demo.Demo0806.Demo01;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            System.out.println("尝试第" + i + "次");
        }

        return "成功";
    }
}
