package cn.dino.demo.Demo0728.Demo02;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    /*
    * - LinkedHashSet集合特点：
    *   - 哈希表(Hash)和链表(Linked)实现的Set接口，具有可预测的迭代次序
    *   - 由链表保证元素有序，元素的存储和取出顺序一致
    *   - 由哈希表保证元素唯一，即无重复的元素
    * */
    public static void main(String[] args) {
        System.out.println("--Use Linked Hash Set--");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Dino");
        set.add("Peppa");
        set.add("Pedro");
        for (String v : set) {
            System.out.print(v + " ");
        }
    }
}
