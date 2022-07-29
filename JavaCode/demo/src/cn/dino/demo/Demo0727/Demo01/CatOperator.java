package cn.dino.demo.Demo0727.Demo01;

import cn.dino.demo.Demo0727.Demo01.pojo.Cat;

/*
 * 普通类作为参数和返回值
 * */
public class CatOperator {
    public void useCat(Cat cat) {
        cat.eat();
    }

    public Cat getCat() {
        Cat cat = new Cat();
        return cat;
    }

}
