package cn.dino.demo.Demo0801.Demo04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        // 1、创建 FileReader 读取对象
        FileReader fr = new FileReader("MyFile\\FileWriter\\fw.txt");
        // 2、读取数据
        /*int by;     // 单字节读取
        while ((by = fr.read()) != -1) {
            System.out.print(by + " ");
        }*/
        char[] chars = new char[1024];    // 多字节读取，与字节IO流不同；字节IO流定义方法：　byte[] bys = new byte[1024];
        int len;    // 偏移长度
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
    }
}
