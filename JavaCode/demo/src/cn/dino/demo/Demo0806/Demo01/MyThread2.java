package cn.dino.demo.Demo0806.Demo01;

public class MyThread2 extends Thread {
    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + i);
        }
    }
}
