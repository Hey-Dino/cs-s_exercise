package cn.dino.demo.Demo0728.Demo01;

import java.util.Arrays;

public class SortStringArrary {
    public static void main(String[] args) {
        String str = "12 32 5 10 23 55";
        System.out.println(SortArray(str));
    }

    public static String SortArray(String str) {
        // 将字符串转换为字符数组
        String[] arrString = str.split(" ");

        // 将字符转化为整型数组
        int[] arrInt = new int[arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            arrInt[i] = Integer.parseInt(arrString[i]);
        }

        // 排序整型数组
        Arrays.sort(arrInt);

        // 返回升序的数组的字符串形式
        return Arrays.toString(arrInt);
    }
}
