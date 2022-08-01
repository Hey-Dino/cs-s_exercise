package cn.dino.demo.Demo0729.Demo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(5);
        list.add(32);
        System.out.println("Original:" + list);

        // sort()
        Collections.sort(list);
        System.out.println("Sort: " + list);
        // reverse()
        Collections.reverse(list);
        System.out.println("Reverse: " + list);
        // shuffle()，使用默认的随机源随机排列指定的列表
        Collections.shuffle(list);
        System.out.println("Shuffle: " + list);
    }
}
