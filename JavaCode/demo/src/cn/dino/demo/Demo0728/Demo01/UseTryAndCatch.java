package cn.dino.demo.Demo0728.Demo01;

public class UseTryAndCatch {
    public static void main(String[] args) {
        int[] arr = {12, 5, 31, 12};
        try {
            System.out.println(arr[arr.length]);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // 该语句仍会执行
        System.out.println("Hello, World!");
    }
}
