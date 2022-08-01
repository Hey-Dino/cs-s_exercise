package cn.dino.demo.Demo0729.Demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * ArrayList 内含 HashMap
 * */
public class ArrayListIncludeHashMapDemo {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        HashMap<String, String> hashMap01 = new HashMap<>();
        hashMap01.put("001", "Dino");
        hashMap01.put("002", "Pedro");
        hashMap01.put("003", "Peppa");
        // 将 hashMap01 添加到 arrayList 中
        arrayList.add(hashMap01);

        HashMap<String, String> hashMap02 = new HashMap<>();
        hashMap02.put("001", "George");
        hashMap02.put("002", "Tim");
        hashMap02.put("003", "Pink");
        // 将 hashMap02 添加到 arrayList 中
        arrayList.add(hashMap02);

        System.out.println(arrayList);
        // 遍历
        for (HashMap<String, String> hashMap : arrayList) {
            // 获取键的集合
            Set<String> keySet = hashMap.keySet();
            for (String key : keySet) {
                // 通过键，获取HashMap中的值
                String val = hashMap.get(key);

                System.out.println("key: " + key + " value: " + val);
            }
            System.out.println("----------");
        }
    }
}
