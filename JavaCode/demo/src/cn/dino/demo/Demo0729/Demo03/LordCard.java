package cn.dino.demo.Demo0729.Demo03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LordCard {
    /*
     * 洗牌
     * */
    public static List<String> shuffleCard() {
        List<String> breakCards = new ArrayList<>();

        // 花色
        String[] colors = {"♦", "♣", "♥", "♠"};
        // 点数
        String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        // 形成牌号
        for (String color : colors) {
            for (String num : nums) {
                breakCards.add(color + num);
            }
        }
        breakCards.add("小王");
        breakCards.add("大王");

        // 洗牌，即打散
        Collections.shuffle(breakCards);

        return breakCards;
    }

    /*
     * 发牌
     * */
    public static List[] dealCard(List<String> breakCard) {
        List<String> cardGroup1 = new ArrayList<>();
        List<String> cardGroup2 = new ArrayList<>();
        List<String> cardGroup3 = new ArrayList<>();
        // 底牌
        List<String> dpGroup = new ArrayList<>();

        for (int i = 0; i < breakCard.size(); i++) {
            String card = breakCard.get(i);
            // 总共54张牌，最后3张为底牌
            if (i >= breakCard.size() - 3) {
                dpGroup.add(card);
            } else if (i % 3 == 0) {
                cardGroup1.add(card);
            } else if (i % 3 == 1) {
                cardGroup2.add(card);
            } else if (i % 3 == 2) {
                cardGroup3.add(card);
            }
        }

        // 返回一个集合数组
        List[] cardGroups = {cardGroup1, cardGroup2, cardGroup3, dpGroup};
        return cardGroups;
    }

    /*
     * 看牌
     * */
    public static void showCards(String[] playerNames, List[] cardGroups) {
        // 输出玩家的牌
        for (int i = 0; i < playerNames.length; i++) {
            List<String> cardGroup = cardGroups[i];

            System.out.println(playerNames[i] + "的牌是：");
            for (String card : cardGroup) {
                System.out.print(card + " ");
            }
            System.out.println();
        }

        // 输出底牌
        List<String> dpGroup = cardGroups[cardGroups.length - 1];
        System.out.println("底牌是：");
        for (String card : dpGroup) {
            System.out.print(card + " ");
        }
    }
}
