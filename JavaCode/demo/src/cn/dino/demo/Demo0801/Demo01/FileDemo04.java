package cn.dino.demo.Demo0801.Demo01;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileDemo04 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("MyFile\\FileDemo04");
        f1.mkdir();
        File f2 = new File("MyFile\\FileDemo04\\Demo01.txt");
        f2.createNewFile();

        System.out.println("f1's pathname: FileDemo04\nf2's pathname: FileDemo04\\Demo01.txt\n");
        /*
        * 1.File 类的判断功能
        * */
        System.out.println("-----判断功能-----");
        System.out.println("f1 is directory: " + f1.isDirectory());
        System.out.println("f2 is File: " + f2.isFile());
        System.out.println("f1 is exists: " + f1.exists());

        /*
        * 2.获取功能
        * */
        System.out.println("-----获取功能-----");
        System.out.println("f1's absolute path: " + f1.getAbsolutePath());
        System.out.println("f2's absolute path: " + f2.getAbsolutePath());
        System.out.println("-----");
        System.out.println("f1's path: " + f1.getPath());
        System.out.println("f2's path: " + f2.getPath());
        System.out.println("-----");
        System.out.println("f1's name: " + f1.getName());
        System.out.println("f2's name: " + f2.getName());
        System.out.println("-----");
        System.out.println("listFiles():");
        File[] listFiles = f1.listFiles();    // 查找当前f1路径下的文件
        for (File file:listFiles) {
            if (file.isFile()) {
                System.out.print(file.getName());
            }
        }
    }
}
