package cn.dino.demo.Demo0806.Demo01;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        // 直接调用run()方法，类似于调用普通方法，无异步
        // m1.run();
        // m2.run();

        // 调用start()方法，不同线程间会相互抢夺CPU资源
        m1.start();
        m2.start();
    }
}
