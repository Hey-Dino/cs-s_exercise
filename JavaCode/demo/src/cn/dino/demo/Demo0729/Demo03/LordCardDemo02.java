package cn.dino.demo.Demo0729.Demo03;

import java.util.List;
import java.util.TreeSet;

public class LordCardDemo02 {
    public static void main(String[] args) {
        List<Integer> breakIndex = LordCardUpgrade.shuffleCard();
        TreeSet[] indexGroups = LordCardUpgrade.dealCard(breakIndex);

        // 玩家名称
        String[] playerNames = {"Peppa", "George", "Pedro"};
        LordCardUpgrade.showCards(playerNames, indexGroups);
    }
}
