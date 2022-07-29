package cn.dino.demo.Demo0727.Demo01.pojo;

public class Cat extends Animal implements Jumping {
    @Override
    public void eat() {
        System.out.println("猫吃鱼！");
    }

    @Override
    public void jump() {
        System.out.println("猫可以跳得很高！");
    }
}
