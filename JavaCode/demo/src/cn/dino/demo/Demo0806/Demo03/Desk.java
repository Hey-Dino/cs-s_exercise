package cn.dino.demo.Demo0806.Demo03;

public class Desk {
    // 桌子上是否有汉堡包的标记
    //  - true 代表桌上有汉堡包，允许吃货食用，不允许厨师制作
    //  - false 代表桌上无汉堡包，允许厨师制作，不允许吃货食用
    public static boolean flag = false;

    // 所能制作的汉堡包的数量，也代表待制作的汉堡包的数量
    public static int count = 10;

    // 同步锁
    public static final Object lock = new Object();
}
