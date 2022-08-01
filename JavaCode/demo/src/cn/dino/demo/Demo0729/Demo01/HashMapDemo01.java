package cn.dino.demo.Demo0729.Demo01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo01 {
    public static void main(String[] args) {
        // 创建 HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        // 元素操作
        hashMap.put(1, "Dino");     // 添加元素
        hashMap.put(1, "Pedro");    // 键值唯一；键值相同的情况下，后面添加的元素会覆盖前面添加的元素
        hashMap.put(2, "Pedro");
        hashMap.put(3, "George");
        // hashMap.remove(2);      // 删除元素
        // System.out.println("Hash Map is Empty? " + hashMap.isEmpty());   // 是否为空
        // System.out.println("Hash Map's size: " + hashMap.size());      // 长度
        // System.out.println("Is contains key 2? " + hashMap.containsKey(2));         // 是否包含键
        // System.out.println("Is Contains value Dino? " + hashMap.containsValue("Dino"));  // 是否包含值
        // hashMap.clear();    // 清空


        System.out.println("Hash Map: " + hashMap);
        System.out.println("Keys: " + hashMap.keySet());
        System.out.println("Values: " + hashMap.values());
        // 遍历方式一
        System.out.println("--遍历方式一--");
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {
            String val = hashMap.get(key);
            System.out.println(key + "~" + val);
        }

        // 遍历方式二
        System.out.println("--遍历方式二--");
        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<Integer, String> me : entrySet) {
            // System.out.println(me);
            int key = me.getKey();
            String val = me.getValue();
            System.out.println(key + "-" + val);
        }
    }
}
