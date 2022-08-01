package cn.dino.demo.Demo0801.Demo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        /*
        * 注意点：
        *   1.如果文件不存在，会自动创建；但不会自动创建文件夹
        *   2.如果文件存在，会清空文件
        * */

        File file = new File("MyFile\\FileOutputStream");
        file.mkdir();
        // 1、创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("MyFile\\FileOutputStream\\fos.txt");
        // 2、将指定字节写入该字节输出流
        /*fos.write(97);      // 写入方式一，写入指定字节
        fos.write(98);
        fos.write(99);
        fos.write(100);*/
        // fos.write(new byte[]{97, 98, 99, 100});      // 写入方式二，写入指定byte数组
        // fos.write("abcd".getBytes());
        fos.write("abcd".getBytes(), 1, 3);     // 写入方式三，参数二为偏移位置，参数三为偏移长度

        // 3、释放资源
        fos.close();
    }
}
