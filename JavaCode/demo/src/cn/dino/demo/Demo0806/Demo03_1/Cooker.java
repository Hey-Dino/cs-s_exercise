package cn.dino.demo.Demo0806.Demo03_1;

import cn.dino.demo.Demo0806.Demo03_1.Desk;

public class Cooker extends Thread {
    private Desk desk;

    public Cooker() {
    }

    // 重写的构造方法
    public Cooker(Desk desk) {
        this.desk = desk;
    }

    public Cooker(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (desk.getLock()) {
                // 判断汉堡包是否全部制作完成
                if (desk.getCount() == 0) {
                    break;
                } else {
                    // 判断桌子是否为空，是否有位置制作汉堡包
                    if (!desk.isFlag()) {
                        System.out.println("厨师[" + getName() + "]在制作汉堡包");
                        // 切换标志，表示桌上有汉堡包
                        desk.setFlag(true);
                        // 通知其他进程
                        desk.getLock().notifyAll();
                    } else {
                        try {
                            // 桌上有面包，等待
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
