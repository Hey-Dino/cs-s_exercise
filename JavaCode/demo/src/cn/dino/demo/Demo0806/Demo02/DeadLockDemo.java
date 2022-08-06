package cn.dino.demo.Demo0806.Demo02;

public class DeadLockDemo {
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (objA) {
                    // 线程一
                    synchronized (objB) {
                        System.out.println("Dino正在赶路");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (objB) {
                    // 线程二
                    synchronized (objA) {
                        System.out.println("Pedro正在赶路");
                    }
                }
            }
        }).start();
    }
}