package cn.dino.demo.Demo0729.Demo03;

import java.util.List;

public class LordCardDemo01 {
    public static void main(String[] args) {
        List<String> breakCards = LordCard.shuffleCard();
        List[] cardGroup = LordCard.dealCard(breakCards);

        String[] playerNames = {"Peppa", "George", "Pedro"};
        LordCard.showCards(playerNames, cardGroup);
    }
}
