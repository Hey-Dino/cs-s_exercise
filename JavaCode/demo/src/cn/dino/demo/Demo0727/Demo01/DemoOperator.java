package cn.dino.demo.Demo0727.Demo01;

import cn.dino.demo.Demo0727.Demo01.pojo.Animal;
import cn.dino.demo.Demo0727.Demo01.pojo.Cat;
import cn.dino.demo.Demo0727.Demo01.pojo.Jumping;

public class DemoOperator {
    public static void main(String[] args) {
        System.out.println("-----抽象类作为方法的参数、返回值-----");
        AnimalOperator animalOperator = new AnimalOperator();
        Animal animal = animalOperator.getAnimal();
        animalOperator.useAnimal(animal);

        System.out.println("-----接口作为方法的参数、返回值-----");
        JumpingOperator jumpingOperator = new JumpingOperator();
        Jumping jumping = jumpingOperator.getJumping();
        jumpingOperator.useJumping(jumping);

        System.out.println("-----普通类作为方法的参数、返回值-----");
        CatOperator catOperator = new CatOperator();
        Cat cat = catOperator.getCat();
        catOperator.useCat(cat);
    }
}
