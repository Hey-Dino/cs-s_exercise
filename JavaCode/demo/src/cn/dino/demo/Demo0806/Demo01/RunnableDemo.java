package cn.dino.demo.Demo0806.Demo01;

public class RunnableDemo {
    public static void main(String[] args) {
        // 1、创建 MyRunnable 类的对象
        MyRunnable mr = new MyRunnable();

        // 2、创建 Thread 类的对象，把 MyRunnable 类的对象作为构造方法的参数
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.setName("~线程1~");
        t2.setName("-线程2-");
        /*Thread t1 = new Thread(mr, "~线程1~");    // 定义线程名称
        Thread t2 = new Thread(mr, "-线程2-");*/

        // 3、开启线程
        t1.start();
        t2.start();
    }
}
