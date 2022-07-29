package cn.dino.demo.Demo0728.Demo03;

public class GenericDemo {
    public static void main(String[] args) {
        GenericImpl<Integer> generic =  new GenericImpl<>();
        // 调用泛型类中的普通方法
        generic.show(123);
        // 调用泛型类中的泛型方法
        generic.show02("Dino");
        generic.show02(12.3);
        generic.show02(120);
        generic.show02(true);
    }
}
