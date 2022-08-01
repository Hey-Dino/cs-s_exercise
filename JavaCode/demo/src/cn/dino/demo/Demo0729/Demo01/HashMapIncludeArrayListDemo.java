package cn.dino.demo.Demo0729.Demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapIncludeArrayListDemo {
    public static void main(String[] args) {
        // 创建 HashMap 集合
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        /*
        * 由于 HashMap 的键值对是按[键名]升序排列的
        * 因而，list1虽先于list2加入到 hashMap，但存储于list2之后。
        * */

        // 创建 ArrayList 集合
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Peppa");
        list1.add("George");
        list1.add("Pedro");
        // 把 ArrayList 作为元素添加到 HashMap 集合
        hashMap.put("小猪佩奇", list1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("玛卡巴卡");
        list2.add("唔西迪西");
        list2.add("依古比古");
        hashMap.put("花园宝宝", list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("莱德");
        list3.add("毛毛");
        list3.add("阿奇");
        hashMap.put("汪汪队立大功", list3);

        // 遍历
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            ArrayList<String> roles = hashMap.get(key);
            for (String name : roles) {
                System.out.print(name + " ");
            }
            System.out.println("\n----------");
        }
    }
}
