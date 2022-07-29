package cn.dino.demo.Demo0725.Case02;

public abstract class Animal {
    int age = 15;

    public Animal() {
    }

    public Animal(int age) {
        this.age = age;
    }

    abstract void eat();
}
