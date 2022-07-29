package cn.dino.demo.Demo0728.Demo02;

import cn.dino.demo.Demo0728.pojo.Student;

import java.util.HashSet;

public class UseHashCode {
    // Hash值和元素内容并不一定一一对应，如“重地”和“通话”的Hash值一样
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        System.out.println("--Student No.1's hash code:--");
        Student stu1 = new Student(20, "Dino");
        // 同一个对象多次调用hashCode()方法返回的哈希值是相同的
        System.out.println(stu1.hashCode());
        System.out.println(stu1.hashCode());
        // 默认情况下，不同对象的哈希值是不相同的
        // 通过方法重写，可以实现不同对象的哈希值是相同的
        System.out.println("--Student No.2's hash code:--");
        Student stu2 = new Student(22, "Peppa");
        System.out.println(stu2.hashCode());
        // 存在相同哈希值的情况
        System.out.println("--Identical Hash Code:--");
        System.out.println("重地的哈希值：" + ("重地".hashCode()));
        System.out.println("通话的哈希值：" + ("通话".hashCode()));
    }
}
