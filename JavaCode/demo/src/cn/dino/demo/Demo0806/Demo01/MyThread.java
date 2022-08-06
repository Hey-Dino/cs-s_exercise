package cn.dino.demo.Demo0806.Demo01;

public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    /*
    * 重写 run() 方法的原因：
    *   - run() 是用来封装被线程执行的代码
    * */
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + i);
        }
    }
}
