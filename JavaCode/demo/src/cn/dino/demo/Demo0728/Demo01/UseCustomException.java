package cn.dino.demo.Demo0728.Demo01;

import cn.dino.demo.Demo0728.pojo.ScoreException;
import cn.dino.demo.Demo0728.pojo.Teacher;

import java.util.Scanner;

public class UseCustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input your score:");
        int score = sc.nextInt();
        try {
            new Teacher().checkScore(score);
        } catch (ScoreException e) {
            e.printStackTrace();
        }
    }
}
