package cn.dino.demo.Demo0727.Demo01;

import cn.dino.demo.Demo0727.Demo01.pojo.Animal;
import cn.dino.demo.Demo0727.Demo01.pojo.Cat;

/*
* 抽象类作为参数和返回值
* */
public class AnimalOperator {
    public void useAnimal(Animal animal) {
        animal.eat();
    }

    public Animal getAnimal() {
        Animal animal = new Cat();

        return animal;
    }
}
