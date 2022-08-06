package cn.dino.demo.Demo0806.Demo02;

import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable {
    private int tickets = 100;
    private Object obj = new Object();
    // private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            /* 同步解决方案一：synchronized */
            synchronized (obj) {
                /* 同步解决方法二：Lock锁 */
                // lock.lock();

                if (tickets <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "在买票，还剩下" + tickets-- + "张票");
                }

                // lock.unlock();
            }
        }
    }
}
