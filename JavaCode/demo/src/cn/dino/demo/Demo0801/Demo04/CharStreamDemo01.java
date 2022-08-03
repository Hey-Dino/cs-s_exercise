package cn.dino.demo.Demo0801.Demo04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamDemo01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your name: ");
        String name = sc.next();
        System.out.print("Please input your password: ");
        String pwd = sc.next();

        // 提取创建新文件夹
        File file = new File("MyFile\\CharStream");
        file.mkdirs();

        // 1、创建 FileWriter 写入对象
        FileWriter fw = new FileWriter(new File(file, "UserInfo.txt"));
        // 2、写入对象名和密码
        fw.write(name);
        fw.write("\r\n");
        fw.write(pwd);
        // 3、刷新流
        fw.flush();
        // 4、释放资源
        fw.close();
    }
}
