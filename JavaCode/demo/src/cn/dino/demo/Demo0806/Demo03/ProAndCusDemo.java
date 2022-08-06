package cn.dino.demo.Demo0806.Demo03;

public class ProAndCusDemo {
    /*
    * 生产者与消费者问题 测试类
    * */
    public static void main(String[] args) {
        // 创建生产者、消费者线程对象
        Cooker cooker = new Cooker("一");
        Customer customer = new Customer("一");

        // 开启线程
        cooker.start();
        customer.start();
    }
}
