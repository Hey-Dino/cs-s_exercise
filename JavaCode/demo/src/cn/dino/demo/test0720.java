package cn.dino.demo;

public class test0720 {
    public static void main(String[] args) {
        // 数组格式化打印
        int[] arr = {11, 22, 33, 44, 55};
        // printArr(arr);

        // 打印指定区间的奇数
        // printOdd(10, 50);

        // 数组反转
        // arrayInversion(arr);

        // 重载
        /*System.out.println(compare(10, 20));
        System.out.println(compare((byte) 10, (byte) 20));
        System.out.println(compare(10L, 20L));*/

/*        System.out.println("二进制：" + 0b1000);  // 二进制：8
        System.out.println("八进制："+ 010);  // 八进制：8
        System.out.println("十六进制："+0x10);  // 十六进制：16
        System.out.println(10 ^ 5 ^ 10);  // 1010^0101^1010z*/

        /*int[][] array = {{22, 66, 44}, {77, 33, 88}, {25, 45, 65}, {11, 66, 99}};
        System.out.println(sumBinaryArray(array));*/

        // System.out.println(0b1000<<2);
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.toDegrees(Math.PI));
        System.out.println(Math.toRadians(180));
        System.out.println(Math.floor(1.6));
        System.out.println(Math.round(1.6));
        System.out.println(Math.ceil(1.6));
    }

    // 格式化打印数组
    public static void printArr(int[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }

    // 打印指定区间的奇数
    public static void printOdd(int start, int end) {
        int count = 0;

        System.out.println("区间" + start + "~" + end + "的奇数为：");
        for (int i = start; i < end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");

                count++;
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }

    // 数组反转
    public static void arrayInversion(int[] arr) {
        System.out.print("转换前的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int start = 0;
        int end = arr.length - 1;
        for (; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        System.out.println();
        System.out.print("转换后的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 方法重载
    public static boolean compare(int a, int b) {
        System.out.println("--int--");

        return a == b;
    }

    public static boolean compare(byte a, byte b) {
        System.out.println("--int--");

        return a == b;
    }

    public static boolean compare(long a, long b) {
        System.out.println("--int--");

        return a == b;
    }

    // 二维数组求和
    public static int sumBinaryArray(int[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }
}