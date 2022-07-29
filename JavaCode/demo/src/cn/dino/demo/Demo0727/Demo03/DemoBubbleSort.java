package cn.dino.demo.Demo0727.Demo03;

import java.util.Arrays;

public class DemoBubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 32, 5, 13, 22, 19};

        // 调用冒泡排序的方法
        int[] result = BubbleSort.doSort(arr.clone());

        // 自定义类——将 数组 转化为 字符串
        System.out.println(arrToString(arr));
        System.out.println("冒泡排序的结果：");
        // API Arrays
        System.out.println(Arrays.toString(result));
    }

    /*
    * 数组转字符串的方法
    * */
    public static String arrToString(int[] arr) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                builder.append(arr[i] + "]");
            } else {
                builder.append(arr[i] + ", ");
            }
        }

        return builder.toString();
    }
}
