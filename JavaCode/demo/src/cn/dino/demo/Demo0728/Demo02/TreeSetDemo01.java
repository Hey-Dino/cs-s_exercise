package cn.dino.demo.Demo0728.Demo02;

import java.util.TreeSet;

public class TreeSetDemo01 {
    /*
    * - TreeSet 集合概述：
    *   - 元素有序，可以按照一定的规则进行排序，具体排序方式取决于构造方法
    *       - TreeSet(): 根据其元素的自然排序进行排序，可以通过实现Comparable<T>接口实现
    *       - TreeSet(Comparator comparator): 根据指定的比较强进行排序，比较器就是以匿名类方式实现compareTo()方法
    *   - 元素唯一、不重复
    *   - 没有索引值
    *
    * - 实现自定义规则排序的两种方法：
    *   - 使需要排序的类实现接口Comparable<T>并重写其compareTo()方法
    *   - 在new TreeSet<>() 时加入参数new Comparator<Student>()，即实用匿名内部类重写compareTo()方法
    * */
    public static void main(String[] args) {
        System.out.println("--Tree Set--");
        TreeSet<Integer> set = new TreeSet<>();

        // 添加非递增的数值
        set.add(10);
        set.add(5);
        set.add(1);
        set.add(20);
        set.add(20);    // 输入重复元素

        for (int v : set) {
            System.out.print(v + " ");
        }
    }
}
