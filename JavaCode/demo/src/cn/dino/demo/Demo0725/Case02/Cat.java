package cn.dino.demo.Demo0725.Case02;

public class Cat extends Animal implements Jumping {
    int age = 10;

    public Cat() {

    }

    public Cat(int age) {
        super(age);
    }

    @Override
    void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void jump() {
        System.out.println("猫跳得很高");
    }
}
