package cn.dino.demo.Demo0728.Demo02;

import cn.dino.demo.Demo0728.pojo.Student;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo02 {
    public static void main(String[] args) {
        System.out.println("--Tree Set--");
        // TreeSet<Student> students = new TreeSet<>();
        // 若泛型所指定的类实现 Comparable<Student>接口并重写其compareTo()方法，可以不使用下方的构造器
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getName().compareTo(o2.getName());
                int num2 = num == 0 ? o1.getAge() - o2.getAge() : num;

                return num2;
            }
        });

        students.add(new Student(20, "Dino"));
        students.add(new Student(22, "Peppa"));
        students.add(new Student(20, "Peppa"));

        for (Student stu : students) {
            System.out.println(stu.getName() + " " + stu.getAge());
        }
    }
}
