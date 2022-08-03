package cn.dino.demo.Demo0801.Demo05;

import java.io.*;

public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
        // 创建待存储文件的目录
        File file = new File("MyFile\\ConversionStream");
        file.mkdirs();

        // 1、创建 OutputStreamWriter 对象，并写入数据
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("MyFile\\ConversionStream\\osw.txt"), "GBK");
        osw.write("我爱你中国");
        osw.close();

        InputStreamReader isr = new InputStreamReader(new FileInputStream("MyFile\\ConversionStream\\osw.txt"), "GBK");
        // 一次读取一个字符数据
        int ch;
        while((ch = isr.read()) != -1) {
            System.out.print((char) ch + " ");
        }
        isr.close();
    }
}
