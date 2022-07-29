package cn.dino.demo.Demo0727.Demo03;

public class UseSystem {
    public static void main(String[] args) {
        int num = (int) Math.pow(10, 5);

        long start = System.currentTimeMillis();
        for (int i = 1; i <= num; i++) {
            System.out.print(i + " ");
            if (i % 100 == 0) {
                System.out.println();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("打印" + num + "个数字所消耗的时间：" + (end - start) + "ms");
    }
}
