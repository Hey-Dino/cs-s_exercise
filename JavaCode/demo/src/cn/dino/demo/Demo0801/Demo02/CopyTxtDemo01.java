package cn.dino.demo.Demo0801.Demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTxtDemo01 {
    public static void main(String[] args) throws IOException {
        // 字节输入流，用于读文件
        FileInputStream fis = new FileInputStream("MyFile\\FileInputStream\\fis.txt");
        // 字节输出流，用于写文件
        FileOutputStream fos = new FileOutputStream("MyFile\\FileOutputStream\\fis.txt");

        // 读写数据（循环一次，读写一个字节数据）
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 释放资源
        fis.close();
        fos.close();
    }
}
