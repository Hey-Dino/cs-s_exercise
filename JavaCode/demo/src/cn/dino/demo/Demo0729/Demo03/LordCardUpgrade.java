package cn.dino.demo.Demo0729.Demo03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/*
* 相比于普通版 LordCard.java，升级版不再打乱牌号集合，而是打乱索引集合。
* 打乱的索引集合分成4份后，被存储于TreeSet结构中；由于TreeSet的特性，每一份索引集合被重新排序。
* 借助再次排好序的索引集合、有序的牌号集合，便能得到四份有序牌组。
* */
public class LordCardUpgrade {
    // valueList 存储是排序好的牌号，其是不变的。
    // IndexList 存储的索引值（每个索引对应一个牌号），其是会被打乱的。
    private static ArrayList<String> valueList;

    /*
     * 洗牌
     * */
    public static List<Integer> shuffleCard() {
        // index 作为洗牌和分牌的依据
        ArrayList<Integer> indexList = new ArrayList<>();
        valueList = new ArrayList<>();

        int index = 0;
        // 花色
        String[] colors = {"♦", "♣", "♥", "♠"};
        // 点数
        String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        // 形成牌号，需要是相关点数处在一起
        for (String num : nums) {
            for (String color : colors) {
                valueList.add(color + num);
                indexList.add(index++);
            }
        }
        valueList.add("小王");
        indexList.add(index++);
        valueList.add("大王");
        indexList.add(index++);

        // 洗牌，即打散
        Collections.shuffle(indexList);

        return indexList;
    }

    /*
     * 发牌
     * */
    public static TreeSet[] dealCard(List<Integer> breakIndex) {
        TreeSet<Integer> indexGroup1 = new TreeSet<>();
        TreeSet<Integer> indexGroup2 = new TreeSet<>();
        TreeSet<Integer> indexGroup3 = new TreeSet<>();
        TreeSet<Integer> dpGroup = new TreeSet<>();

        for (int i = 0; i < breakIndex.size(); i++) {
            int index = breakIndex.get(i);

            if (i >= breakIndex.size() - 3) {
                dpGroup.add(index);
            } else if (i % 3 == 0) {
                indexGroup1.add(index);
            } else if (i % 3 == 1) {
                indexGroup2.add(index);
            } else if (i % 3 == 2) {
                indexGroup3.add(index);
            }
        }

        // 返回一个集合数组
        TreeSet[] indexGroups = {indexGroup1, indexGroup2, indexGroup3, dpGroup};
        return indexGroups;
    }

    /*
     * 看牌
     * */
    public static void showCards(String[] playerNames, TreeSet[] indexGroups) {
        // 输出玩家的牌
        for (int i = 0; i < playerNames.length; i++) {
            TreeSet<Integer> indexGroup = indexGroups[i];

            System.out.println(playerNames[i] + "的牌是：");
            for (int index : indexGroup) {
                System.out.print(valueList.get(index) + " ");
            }
            System.out.println();
        }

        // 输出底牌
        TreeSet<Integer> dpGroup = indexGroups[indexGroups.length - 1];
        System.out.println("底牌是：");
        for (int index : dpGroup) {
            System.out.print(valueList.get(index) + " ");
        }
    }
}
