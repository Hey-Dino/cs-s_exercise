package cn.dino.demo.Demo0801.Demo02;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        /*
        * 1、实现追加，而非覆盖
        *   FileOutputStream构造方法的第二个参数为 boolean append，默认为false。
        * */
        FileOutputStream fos = new FileOutputStream("MyFile\\FileOutputStream\\fos.txt", true);

        /*
        * 2、实现换行
        *   - window 下\r代表回车，\n代表换行，\r\n即代表回车换行
        *   -
        * */
        for (int i = 0; i < 10; i++) {
            fos.write((i + "、Hello, FileOutputStream!\r").getBytes());
        }

        // 释放资源
        fos.close();
    }
}
