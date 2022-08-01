package cn.dino.demo.Demo0801.Demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\FileInputStream");
        file.mkdir();

        // 1、创建字节输入流对象
        FileInputStream fis = new FileInputStream("MyFile\\FileInputStream\\fis.txt");

        // 2、循环读出数据
        int by;     // 用于存储读出的字节内容
        while ((by = fis.read()) != -1) {
            System.out.println((char)by);
        }

        // 3、释放资源
        fis.close();
    }
}
