package cn.dino.demo.Demo0801.Demo04;

import java.io.*;
import java.util.Arrays;

public class BufferedStreamDemo03 {
    /*
    * 读取文件数据，排序后，写回原文件
    * */
    public static void main(String[] args) throws IOException {
        // 判断文件夹是否存在
        File file = new File("MyFile\\BufferedStream");
        if (!file.exists()) {
            file.mkdirs();
        }

        // 写入数据，便于下方读取、排序
        BufferedWriter bw = new BufferedWriter(new FileWriter("MyFile\\BufferedStream\\nums.txt"));
        bw.write("12 32 5 20 21 33");
        bw.close();

        // 1、读取数据
        BufferedReader br = new BufferedReader(new FileReader("MyFile\\BufferedStream\\nums.txt"));
        String line = br.readLine();
        System.out.println("读取到的数据为：" + line);
        br.close();

        // 2、排序数据
        String[] split = line.trim().split(" ");    // trim() 用于删除字符串开头、结尾的空格
        int[] arr = new int[split.length];      // 创建新数组，用于存储转换数据类型后的数据
        // 转换数据类型 String -> int
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            int num = Integer.parseInt(str);
            arr[i] = num;
        }
        // 排序新数组
        Arrays.sort(arr);
        System.out.println("排序后的数据为：" + Arrays.toString(arr));

        // 3、写入排序后的数据
        bw = new BufferedWriter(new FileWriter("MyFile\\BufferedStream\\nums.txt"));
        bw.flush();
        for (int num : arr) {
            bw.write(num + " ");
            bw.flush();
        }

        // 4、释放资源
        bw.close();
        br.close();
    }
}
