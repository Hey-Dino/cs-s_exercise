package cn.dino.demo.Demo0728.Demo02;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        // 获取10个1~20之间的随机数
        Set<Integer> nums = new LinkedHashSet<>();

        Random random = new Random();
        while (nums.size() < 10) {
            int num = random.nextInt(20) + 1;
            nums.add(num);
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
