package cn.dino.demo.Demo0801.Demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTxtDemo02 {
    /*
    * 一次读一个字节数组数据
    * */
    public static void main(String[] args) throws IOException {
        // 字节输入流，用于读文件
        FileInputStream fis = new FileInputStream("MyFile\\FileInputStream\\fis.txt");
        // 字节输出流，用于写文件
        FileOutputStream fos = new FileOutputStream("MyFile\\FileOutputStream\\fis.txt");

        byte[] bys = new byte[1024];    // 单次读取的数据大小，1024及其整数倍
        int len;    // 用于临时存数数据
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        // 释放资源
        fis.close();
        fos.close();
    }
}
