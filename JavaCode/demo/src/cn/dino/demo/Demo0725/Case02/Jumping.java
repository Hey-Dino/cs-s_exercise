package cn.dino.demo.Demo0725.Case02;

public interface Jumping {
    /* 接口中的变量必须是公有、静态、常量
    public static final 是默认的，因而可以省略 */
    public static final int height = 1000;
    String name = "Jumping";

    /* 成员方法的修饰符默认是 [public abstract]，同样可以省略 */
    public abstract void jump();
}
