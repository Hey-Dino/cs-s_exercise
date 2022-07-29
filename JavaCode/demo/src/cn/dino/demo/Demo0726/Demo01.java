package cn.dino.demo.Demo0726;

import cn.dino.demo.Demo0726.pojo.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
        /*
        * List集合的特点：
        *   - 有索引
        *   - 可以存储重复元素
        *   - 元素存取有序
        *
        * ArrayList 和 LinkedList 的区别：
        *   - ArrayList 的底层是数组结构实现的，因而查询框、增删慢
        *   - LinkedList 的底层是链表实现的，因而查询慢、增删块
        * */

        Student stu1 = new Student(20, "Dino");
        Student stu2 = new Student(22, "Pedro");
        Student stu3 = new Student(24, "Peppa");

        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);

        // 迭代器循环
        System.out.println("-----迭代器循环-----");
        Iterator<Student> iterator = stuList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 普通for循环
        System.out.println("-----普通for循环-----");
        for (int i = 0; i < stuList.size(); i++) {
            System.out.println(stuList.get(i));
        }

        // 增强for循环
        System.out.println("-----增强for循环-----");
        for (Student stu:
             stuList) {
            System.out.println(stu);
        }

        System.out.println("-----Collection集合的方法-----");
        System.out.println("stuList的长度：" + stuList.size());
        System.out.println("stuList是否为空：" + stuList.isEmpty());
        System.out.println("stuList是否包含stu1：" + stuList.contains(stu1));
        System.out.println("stuList清除stu3是否成功：" + stuList.remove(stu3));
        stuList.set(1, new Student());
        System.out.println("stuList的stu2设置为空对象：" + stuList.get(1));
        stuList.clear();
        System.out.println("stuList清空后的结果：" + stuList);
    }
}
