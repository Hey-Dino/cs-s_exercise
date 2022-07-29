package cn.dino.demo.Demo0725.Case02;

public class Demo02 {
    public static void main(String[] args) {
        /*
         * 多态中成员的访问特点：
         * - 成员变量
         *   编译看父类，运行看[父类]
         * - 成员方法
         *   编译看父类，运行看[子类]
         * */

        /*抽象类多态*/
        System.out.println("--抽象类多态-只能执行抽象类所拥有的变量和方法--");
        Animal animal = new Cat();
        animal.eat();
        // 上转型
        System.out.println(animal.age);
        // 下转型
        Cat cat = (Cat) animal;
        System.out.println(cat.age);
        // 实现了接口的抽象方法
        cat.jump();

        /*接口多态*/
        System.out.println("--接口多态-只能执行接口所拥有的变量和方法--");
        Jumping j = new Cat();
        j.jump();
    }
}
