package cn.dino.demo.Demo0725.Case03;

public class BasketbalCoach extends Coach {
    public BasketbalCoach() {
    }

    public BasketbalCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("篮球教练教如何运球和投篮");
    }

    @Override
    public void eat() {
        System.out.println("篮球教练吃羊肉，喝羊奶");
    }
}
