package cn.dino.demo.Demo0801.Demo01;

import java.io.File;
import java.io.IOException;

public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\FileDemo03");
        file.mkdir();             // 创建待删除的文件夹
        file = new File("MyFile\\FileDemo03\\deletedFile.txt");
        file.createNewFile();     // 创建待删除的文件

        // 1、删除文件
        System.out.println("删除[文件]成功与否：" + file.delete());

        // 2、删除文件夹
        file = new File("MyFile\\FileDemo03");
        System.out.println("删除[文件夹]成功与否：" + file.delete());
    }
}
