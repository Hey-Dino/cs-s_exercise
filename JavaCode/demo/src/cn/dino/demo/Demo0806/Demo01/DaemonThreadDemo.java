package cn.dino.demo.Demo0806.Demo01;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("线程一");
        MyThread2 m2 = new MyThread2("守护线程");

        m1.setPriority(10);

        // 将第二个线程设置为守护线程
        m2.setDaemon(true);

        m1.start();
        m2.start();
    }
}
