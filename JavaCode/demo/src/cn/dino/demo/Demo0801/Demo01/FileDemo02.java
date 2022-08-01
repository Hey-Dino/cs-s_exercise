package cn.dino.demo.Demo0801.Demo01;

import java.io.File;
import java.io.IOException;

public class FileDemo02 {
    public static void main(String[] args) throws IOException {
        /*
        * File 类的创建功能
        *   注意点：若文件、文件夹存在，则返回值均为false；
        *         若要查看具体效果，请删除MyFile文件夹内的所有内容
        * */

        // 1、createNewFile() —— 创建新文件，创建成功返回false，创建失败或文件已存在返回false
        File f1 = new File("MyFile\\test02.txt");
        System.out.println("createNewFile()-[文件]创建成功与否：" + f1.createNewFile());
        // createNewFile() 只能创建文件；若File路径中存在未创建的文件夹，则文件创建失败
        /*File f2 = new File("MyFile\\Dir01\\test02.txt");
        System.out.println("createNewFile()-[文件夹、文件]创建成功与否：" + f2.createNewFile());     // IOException: 系统找不到指定的路径。*/

        // 2、mkdir() —— 创建目录，创建成功返回false，创建失败或目录已存在返回false
        File f3 = new File("MyFile\\Dir01");
        System.out.println("mkdir()-[单级目录]创建成功与否：" + f3.mkdir());
        // mkdir() 只能创建单级目录
        /*File f4 = new File("MyFile\\Dir02\\Dir_Son");
        System.out.println("mkdir()-[多级目录]创建成功与否：" + f4.mkdir());*/

        // 3、mkdirs() —— 创建单级、多级目录，无法创建文件
        File f5 = new File("MyFile\\Dir03");
        System.out.println("mkdirs()-[单级目录]创建成功与否：" + f5.mkdirs());
        File f6 = new File("MyFile\\Dir04\\Dir_Son");
        System.out.println("mkdirs()-[多级目录]创建成功与否：" + f6.mkdirs());
    }
}
