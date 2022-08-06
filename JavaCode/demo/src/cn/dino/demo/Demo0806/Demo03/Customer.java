package cn.dino.demo.Demo0806.Demo03;

public class Customer extends Thread {
    public Customer() {
    }

    public Customer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                // 判断汉堡包是否全部食用完
                if (Desk.count == 0) {
                    break;
                } else {
                    // 判断桌子上是否仍有汉堡包
                    if (Desk.flag) {
                        System.out.println("顾客[" + getName() + "]正在享用汉堡包");

                        // 切换标志，表示桌上已无汉堡包
                        Desk.flag = false;
                        // 待制作的汉堡包的数量减一
                        Desk.count--;
                        // 通知其他线程
                        Desk.lock.notifyAll();
                    } else {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
