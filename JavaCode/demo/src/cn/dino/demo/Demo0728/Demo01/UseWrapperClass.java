package cn.dino.demo.Demo0728.Demo01;

public class UseWrapperClass {
    public static void main(String[] args) {
        // Integer 的使用
        System.out.println(new Integer(100));
        System.out.println(new Integer("100"));
        // 上两种使用时需要创建实例，现如今使用较少，已经过时
        System.out.println(Integer.valueOf(100));
        System.out.println(Integer.valueOf("100"));

        System.out.println();
        // int 和 String 的相互转换
        // int 转 String
        System.out.println((100 + "") instanceof String);   // 利用字符串拼接
        System.out.println(Integer.toString(100));
        System.out.println(String.valueOf(100));
        // String 转 int
        System.out.println((Integer.valueOf("100")).intValue());    // 首先把字符串转化为Integer，然后再进行包装类拆箱
        System.out.println(Integer.parseInt("100"));
    }
}
