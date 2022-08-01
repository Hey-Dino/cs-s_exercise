package cn.dino.demo.Demo0801.Demo01;

import java.io.File;

public class FileDemo01 {
    public static void main(String[] args) {
        /*
        * File 类的三种构造方法
        *   注意点：相对路径是从当前项目的根路径开始的，而非从当前文件的根目录开始的。
        * */

        // File(String pathname)
        File f1 = new File("MyFile\\test01.txt");
        System.out.println(f1);

        // File(String parent, String child)
        File f2 = new File("MyFile", "test01.txt");
        System.out.println(f2);

        // File(File parent, String child)
        File f3 = new File("MyFile");
        File f4 = new File(f3, "test01.txt");
        System.out.println(f4);
    }
}
