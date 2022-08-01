package cn.dino.demo.Demo0801.Demo01;

import java.io.File;
import java.io.IOException;

public class CreateFileIncludeNewDir {
    /*
    * 创建包裹在新目录下的新文件
    * */
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\CreateFileIncludeNewDir");
        // 1.判断文件夹CreateFileIncludeNewDir是否存在
        if (!file.exists()) {
            // 若不存在，则新建
            file.mkdirs();
        }

        // 2.创建新文件
        File newFile = new File("MyFile\\CreateFileIncludeNewDir\\Demo01.txt");
        newFile.createNewFile();
    }
}
