package cn.dino.demo.Demo0727.Demo03;

import java.util.Arrays;

public class UseArrays {
    public static void main(String[] args) {
        int[] arr1 = {12, 4, 22, 13, 33};
        String str = Arrays.toString(arr1);
        System.out.println("array to String:" + str);
        System.out.println("is String: " + (str instanceof String));
    }
}
