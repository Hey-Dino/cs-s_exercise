package cn.dino.demo.Demo0729.Demo02;

import cn.dino.demo.Demo0729.pojo.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionDemo02 {
    public static void main(String[] args) {
        // 1、创建学生对象
        Student stu1 = new Student("Dino", 22);
        Student stu2 = new Student("George", 12);
        Student stu3 = new Student("Pedro", 2);

        // 2、创建集合对象，并添加学生对象
        List<Student> stuArray = new ArrayList<>();
        stuArray.add(stu1);
        stuArray.add(stu2);
        stuArray.add(stu3);

        // 3、使用Collections进行排序，通过匿名内部类的方式定义比较器
        Collections.sort(stuArray, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getAge() - o2.getAge();
                int num2 = (num != 0) ? o1.getName().compareTo(o2.getName()) : 0;

                return num2;
            }
        });

        // 4、循环遍历排序后的结果
        for (Student stu : stuArray) {
            System.out.println(stu);
        }
    }
}
