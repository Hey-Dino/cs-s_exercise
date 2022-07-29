package cn.dino.demo.Demo0728.Demo02;

import cn.dino.demo.Demo0728.pojo.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UseHashSet {
    /*
    * HashSet集合的特点：
    *   - 底层数据结构是哈希表
    *   - 集合无序且无索引，因而无法使用普通for循环进行遍历
    *   - 集合元素不重复
    * */
    public static void main(String[] args) {
        /*
        * 添加基本数据类型的元素
        * */
        System.out.println("--基本数据类型--");
        Set<String> set = new HashSet<>();
        // 为集合添加元素
        set.add("Dino");
        set.add("Peppa");
        set.add("Pedro");
        // 不会重复添加相同元素
        set.add("Pedro");
        // 遍历集合
        for (String v : set) {
            System.out.print(v + " ");
        }
        System.out.println();


        /*
        * 添加对象类型的元素
        * */
        System.out.println("--对象--");
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(20, "Dino"));
        students.add(new Student(22, "Peppa"));
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
