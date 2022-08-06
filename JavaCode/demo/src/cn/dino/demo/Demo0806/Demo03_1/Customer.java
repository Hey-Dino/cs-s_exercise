package cn.dino.demo.Demo0806.Demo03_1;

import cn.dino.demo.Demo0806.Demo03_1.Desk;

public class Customer extends Thread {
    private Desk desk;

    public Customer() {
    }

    // 补充的构造方法
    public Customer(Desk desk) {
        this.desk = desk;
    }

    public Customer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (desk.getLock()) {
                // 判断汉堡包是否全部食用完
                if (desk.getCount() == 0) {
                    break;
                } else {
                    // 判断桌子上是否仍有汉堡包
                    if (desk.isFlag()) {
                        System.out.println("顾客[" + getName() + "]正在享用汉堡包");

                        // 切换标志，表示桌上已无汉堡包
                        desk.setFlag(false);
                        // 待制作的汉堡包的数量减一
                        desk.setCount(desk.getCount() - 1);
                        // 通知其他线程
                        desk.getLock().notifyAll();
                    } else {
                        try {
                            desk.getLock().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
