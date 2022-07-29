package cn.dino.demo.Demo0727.Demo03;

import cn.dino.demo.Demo0727.Demo03.pojo.Student;

public class UseEquals {
    public static void main(String[] args) {
        Student stu1 = new Student(20, "Dino");
        Student stu2 = new Student(20, "Dino");
        System.out.println("stu1: " + stu1);
        System.out.println("stu2: " + stu2);
        System.out.println("stu1 == stu2: " + (stu1 == stu2));
        System.out.println("stu1.equals(stu2): " + stu1.equals(stu2));
    }
}
