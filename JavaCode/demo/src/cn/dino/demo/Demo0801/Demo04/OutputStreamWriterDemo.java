package cn.dino.demo.Demo0801.Demo04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\FileWriter");
        file.mkdir();

        // 1、创建 FileWriter 写入对象
        FileWriter fw = new FileWriter(new File(file, "fw.txt"));
        // 2、写入数据
        fw.write(97);   // void write(int c)
        fw.write(new char[]{98, 99, 100});      // void write(char[] cbuf)
        fw.write(new char[]{101, 102, 103}, 0, 2);      // void write(char[] cbuf, int off, int len) 写入字符数组的一部分
        fw.write("ghijklmn");   // void write(String str)
        fw.write("opqrsv", 0, 3);   // void write(String str, int off, int len)
        // 3、释放资源
        fw.close();
    }
}
