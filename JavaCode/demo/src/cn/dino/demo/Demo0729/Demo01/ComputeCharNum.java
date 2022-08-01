package cn.dino.demo.Demo0729.Demo01;

import java.util.*;

/*
 * 计算用户输入的字符串中，每个字符出现的次数
 * */
public class ComputeCharNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 提示并读取用户输入的字符串
        System.out.println("Please input a string:");
        String line = sc.next();

        System.out.println(compute(line));
        System.out.println(computeIgnoreCase(line));
    }

    /*
     * @param line: 需要计算单个字符出现次数的字符串
     * */
    public static Map<Character, Integer> compute(String line) {
        // 创建Map，用于存储各个字符出现的次数
        Map<Character, Integer> map = new TreeMap<>();

        // 遍历用户输入的字符串
        for (int i = 0; i < line.length(); i++) {
            // 获取单个字符
            char key = line.charAt(i);

            Integer val = map.get(key);
            // val为null，代表hashMap未存储过该字符，则将字符出现次数val赋值为1
            // val不为null，代表hashMap存储过该字符，则将字符出现次数加1即可。
            val = (val == null) ? 1 : val + 1;
            map.put(key, val);
        }

        return map;
    }

    public static Map<Character, Integer> computeIgnoreCase(String line) {
        return compute(line.toLowerCase());
    }
}
