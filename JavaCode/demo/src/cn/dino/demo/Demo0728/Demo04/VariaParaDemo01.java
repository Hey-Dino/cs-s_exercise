package cn.dino.demo.Demo0728.Demo04;

public class VariaParaDemo01 {
    /*
    * - 可变参数的注意事项
    *   - 这里的变量其实是一个数组
    *   - 如果一个方法有多个参数且包含[可变参数]，可变参数要放在最后
    * */
    public static void main(String[] args) {
        System.out.println("--可变参数--");
        System.out.println("Sum: " + sum(22, 32));
        System.out.println("Sum: " + sum(1, 12, 30, 40));
        // 可变参数实际是数组，因而可直接使用数组作为其方法的参数
        int[] nums = {12, 22, 32, 42, 52};
        System.out.println("Sum: " + sum(nums));
    }

    /*
    * int...nums 表示可变参数
    * */
    public static int sum(int...nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
