package cn.dino.demo.Demo0806.Demo03;

public class Cooker extends Thread {
    public Cooker() {
    }

    public Cooker(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                // 判断汉堡包是否全部制作完成
                if (Desk.count == 0) {
                    break;
                } else {
                    // 判断桌子是否为空，是否有位置制作汉堡包
                    if (!Desk.flag) {
                        System.out.println("厨师[" + getName() + "]在制作汉堡包");
                        // 切换标志，表示桌上有汉堡包
                        Desk.flag = true;
                        // 通知其他进程
                        Desk.lock.notifyAll();
                    } else {
                        try {
                            // 桌上有面包，等待
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
