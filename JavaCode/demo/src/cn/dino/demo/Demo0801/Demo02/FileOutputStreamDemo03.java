package cn.dino.demo.Demo0801.Demo02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo03 {
    /*
    * 字节流写入，外加异常处理
    * */
    public static void main(String[] args) {
        FileOutputStream fos=null;
        try {
            // 输出流生成失败，可能产生错误 FileNotFoundException
            fos = new FileOutputStream("MyFile\\FileOutputStream\\fos.txt");
            // 内容写入失败，可能产生错误 IOException
            fos.write("Hello, Java!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 当上方的try报错时，fos为空对象，此时是无法close的。
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
