package cn.dino.demo.Demo0806.Demo03_1;

public class ProAndCusDemo {
    public static void main(String[] args) {
        Desk desk = new Desk();

        // 创建线程对象，并修改线程名
        Cooker cooker = new Cooker(desk);
        cooker.setName("一");
        Customer customer = new Customer(desk);
        customer.setName("一");

        // 启动线程
        cooker.start();
        customer.start();
    }
}
