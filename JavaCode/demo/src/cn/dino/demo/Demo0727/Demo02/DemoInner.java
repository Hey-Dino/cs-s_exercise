package cn.dino.demo.Demo0727.Demo02;

import cn.dino.demo.Demo0727.Demo02.pojo.Cat;
import cn.dino.demo.Demo0727.Demo02.pojo.Dog;
import cn.dino.demo.Demo0727.Demo02.pojo.Jumping;

public class DemoInner {
    public static void main(String[] args) {
        // 使用成员内部类的方法一，要求该成员内部类不是私有的
        /*Outer.InnerMember innerMember = new Outer().new InnerMember();
        innerMember.show();*/
        // 使用成员内部类的方法二
        Outer outer = new Outer();
        outer.useInnerMember();

        System.out.println("-------------");
        // 使用局部内部类
        outer.method();

        System.out.println("-------------");
        /*
        当发现某个方法需要，接口或抽象类的子类对象，我们就可以传递一个匿名内部类过去，来简化传统的
        代码
        */
        // 常规写法
        JumpingOperator jumpingOperator = new JumpingOperator();
        Jumping catJump = new Cat();
        jumpingOperator.useJumping(catJump);
        Jumping dogJump = new Dog();
        jumpingOperator.useJumping(dogJump);

        // 利用匿名内部类，实现简写
        jumpingOperator.useJumping(new Jumping() {
            @Override
            public void jump() {
                System.out.println("[匿名内部类]猫可以跳得很高");
            }
        });
        jumpingOperator.useJumping(new Jumping() {
            @Override
            public void jump() {
                System.out.println("[匿名内部类]狗也可以跳得很高");
            }
        });
    }
}
