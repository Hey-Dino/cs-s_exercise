package cn.dino.demo;

import java.util.Random;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        // judgeDateCate();
        // printNarcissus();
        // weightLossPlan();
        // guessNum();

        // 动态初始化（手动指定数组大小，系统自动为数组赋初始值）
        /* int[] arr1 = new int[3];
        System.out.println("arr1:" + arr1 + " 默认值:" + arr1[0]);
        float[] arr2 = new float[3];
        System.out.println("arr2:" + arr2 + " 默认值：" + arr2[0]);

        char[] arr3 = {'中', '国'};
        System.out.println("arr3:" + arr3 + " arr3[0]:" + arr3[0]);*/

        scoring();
    }

    // 计算奇数偶数个数
    public static void computeOddAndEvenNum() {
        int oddNum = 0, evenNum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evenNum += 1;
            } else {
                oddNum += 1;
            }
        }

        System.out.println("奇数个数：" + oddNum + "\n偶数个数：" + evenNum);
    }

    // 计算折叠次数
    public static void computeFoldNum() {
        //
        int count = 0;
        int mountHeigh = 8000000;
        int paperThickness = 1;

        while (paperThickness < mountHeigh) {
            paperThickness *= 2;
            count++;
        }

        System.out.println("需要折叠：" + count + "次");
    }

    // 区分日期类别（工作日、周末）
    public static void judgeDateCate() {
        Scanner sc = new Scanner(System.in);

        lo:
        while (true) {
            System.out.print("Please input the day: ");
            int day = sc.nextInt();

            switch (day) {
                case 0:
                    System.out.println("Exit.");
                    break lo;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Weekday.");
                    break;
                case 6:
                case 7:
                    System.out.println("Weekend.");
                    break;
                default:
                    System.out.println("Wrong Number Entered!!!");
            }
        }
    }

    // 打印水仙花
    public static void printNarcissus() {
        // 水仙花数量
        int count = 0;

        for (int i = 1; i < 1000; i++) {
            int bits = i % 10;
            int ten = i / 10 % 10;
            int hundredth = i / 100 % 10;

            if ((Math.pow(bits, 3) + Math.pow(ten, 3) + Math.pow(hundredth, 3)) == i) {
                count++;

                if (count % 2 == 0) {
                    System.out.print(i + "\n");
                } else {
                    System.out.print(i + " ");
                }
            }
        }
    }

    // 减肥计划
    public static void weightLossPlan() {
        Scanner sc = new Scanner(System.in);

        lo:
        while (true) {
            System.out.print("请输入日期(输入0退出系统):\n");
            int week = sc.nextInt();

            switch (week) {
                case 0:
                    System.out.println("退出");
                    break lo;
                case 1:
                    System.out.println("跑步");
                    break;
                case 2:
                    System.out.println("游泳");
                    break;
                case 3:
                    System.out.println("慢走");
                    break;
                case 4:
                    System.out.println("动感单车");
                    break;
                case 5:
                    System.out.println("拳击");
                    break;
                case 6:
                    System.out.println("爬山");
                    break;
                case 7:
                    System.out.println("好好吃一顿");
                    break;
                default:
                    System.out.println("您的输入有误");
                    break;
            }
        }
    }

    // 猜数字
    public static void guessNum() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int randomNum = random.nextInt(100) + 1;
        // System.out.println("Random Number: " + randomNum);
        System.out.println("Please input your guess:");
        int guessNum = sc.nextInt();

        while (true) {
            if (guessNum < randomNum) {
                System.out.println("Your guess is small!");
            } else if (guessNum > randomNum) {
                System.out.println("Your guess is big!");
            } else {
                System.out.println("Congratulations, your guessed right!");
                break;
            }

            System.out.println("Please input your guess again:");
            guessNum = sc.nextInt();
        }
    }

    // 评委打分
    public static void scoring() {
        Scanner sc = new Scanner(System.in);

        // 确定评委数量
        System.out.println("Please input the number of judges:");
        int judges = sc.nextInt();

        // 记录评委评分
        int score = 0;
        int[] scores = new int[judges];
        for (int i = 0; i < judges; i++) {
            System.out.println("Please input the score that scoring by the No." + (i + 1) + " judge: ");
            score = sc.nextInt();

            if (score < 0 || score > 100) {
                System.out.println("The score is error!");
                i--;
                continue;
            }

            scores[i] = score;
        }

        // 计算最大值、最小值、总和
        int max = scores[0], min = scores[0];
        int sum = 0;
        for (int i = 1; i < scores.length; i++) {
            if (max > scores[i]) {
                max = scores[i];
            }
            if (min < scores[i]) {
                min = scores[i];
            }

            sum += scores[i];
        }

        // 计算平均分
        int average = (sum - max - min) / (judges - 2);
        System.out.println("The average score is: " + average);
    }
}